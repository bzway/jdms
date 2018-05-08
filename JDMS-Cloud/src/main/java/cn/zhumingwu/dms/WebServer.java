package cn.zhumingwu.dms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import cn.zhumingwu.dms.webserver.FileRead;
import cn.zhumingwu.dms.webserver.util.log;

class WebServer implements Runnable {

	private String Server_root = ""; // server root path
	private String Server_Home = ""; // server home page
	private String Server_Icons_Path = ""; // contain the server Icons Path
	private Socket soc; // Socket that will receive or send data
	private String RequestFromClient = ""; // contain the request String ex: GET /someFile HTTP/1.1
	private String File_Name = ""; // contain the requested File
	private String DIR_HTTP = ""; // contain the name of current directory
	private String NOM_HOTE = "";// Hold the Hostname
	private int position1 = 0;
	private int position2 = 0;
	private BufferedReader in;
	private PrintWriter out;

	// constructor ServeurWeb
	public WebServer(Socket s, String Sroot, String Shome, String Sicons, String Slog)
			throws UnknownHostException, IOException {

		try {
			// initailzing the class Fileds
			System.out.println("initailzing the class Fileds\n");
			Server_root = Sroot;
			Server_Home = Shome;
			Server_Icons_Path = Sicons;

			soc = s;
			// Getting the String sent by client
			in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			// String to be sent by the server
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())), true);

			NOM_HOTE = soc.getInetAddress().getLocalHost().toString();

			run(); // invoking method run() to execute the thread code

		} catch (IndexOutOfBoundsException ie) {
			// handling Error :Bad Request

			log lg = new log();
			// call LogEvent Method From Class log
			lg.LogEvent(Slog, "BAD REQUEST", 2);

		}

	}

	public String DecodeURL(String pth) {
		/*
		 * DecodeURL Method used to Decode URL's having space in their body ex:
		 * /File%20Having%20space.htm = /File Having space.htm
		 */
		String pathWithSpace = "";

		// testing if the request file contain %20
		if (pth.indexOf("%20") == -1) {

			return pth; // returning the same file name
		}

		else {
			StringTokenizer set = new StringTokenizer(pth, "%20");

			int cont = set.countTokens();

			if (!set.hasMoreTokens()) {

				return pth;
			} else {
				try {

					for (int j = 0; j < cont; j++) {

						/*
						 * we build a string replacing %20 with space as the original File
						 */

						pathWithSpace += set.nextToken() + " ";
					}
				} catch (NoSuchElementException ne) {
				}

			}
			return pathWithSpace.substring(0, pathWithSpace.length() - 1);
		}
	}

	public synchronized void run() {

		try {
			// initializing in & out with String received from client and String that will
			// be sent to it
			in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())), true);

		} catch (IOException ioe) {
		}

		try {

			// Getting The System File Separator ex : on windows \ ,on linux /
			String FILE_SEPERATOR = System.getProperty("file.separator");

			// Getting the request string sent by client
			RequestFromClient = in.readLine();

			position1 = RequestFromClient.indexOf("/") + 1;
			position2 = RequestFromClient.indexOf("HTTP") - 1;

			// file_Name contain the path of requested file
			File_Name = Server_root + FILE_SEPERATOR
					+ RequestFromClient.substring(position1, position2).replace('/', '\\');

			// Decoding the file
			File_Name = this.DecodeURL(File_Name);

			// Setting the Name of actual Directory
			DIR_HTTP = RequestFromClient.substring(position1, position2).trim();

			System.out.println("[CLIENT REQUEST]: " + RequestFromClient);
			System.out.println("[REQUESTED FILE]: " + File_Name);
			System.out
					.println("*********************************************" + "**********************************\n");

			File f = new File(File_Name);

			FileRead fl = new FileRead();

			fl.setDirectory_Name(DIR_HTTP);
			// testing if the requested file is a directory
			if (f.isDirectory()) {

				if (new File(File_Name + Server_Home).exists())
					// if the welcome page exist we will send its content
					fl.ReadFile(File_Name + Server_Home, NOM_HOTE, soc.getOutputStream(),
							RequestFromClient.substring(position1, position2));
				else
					fl.Listdir(File_Name, soc.getOutputStream(), NOM_HOTE, Server_Icons_Path);
				// otherwise we list the content of the directory
			} else {
				// if the requested file is a file we read its content and we sent it to the
				// client almost (browser)
				fl.ReadFile(File_Name, NOM_HOTE, soc.getOutputStream(),
						RequestFromClient.substring(position1, position2));
			}

		} catch (IOException ioe) {

		} finally {
			try {
				soc.close(); // we always close the socket to free the bandwidth
			} catch (IOException ioe) {
			}
		}
	}
}