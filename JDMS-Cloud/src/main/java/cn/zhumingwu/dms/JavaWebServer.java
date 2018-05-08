package cn.zhumingwu.dms;

import cn.zhumingwu.dms.webserver.Settings;
import cn.zhumingwu.dms.webserver.util.log;

import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaWebServer {

	// Defining AssoWebSrv variables

	private int SERVER_PORT;
	private String SERVER_ROOT;
	private String SERVER_HOMEPAGE;
	private String SERVER_ICONS;
	private String SERVER_LOG;

	JavaWebServer() {
		this.SERVER_PORT = 8080;
		this.SERVER_ROOT = System.getProperty("user.dir");
		this.SERVER_HOMEPAGE = "index.html";
		this.SERVER_ICONS = "/icons/";
		this.SERVER_LOG = System.getProperty("user.dir") + "\\log.txt";
	}

	JavaWebServer(int port, String root, String defaultPage, String icon, String logPath) {
		this.SERVER_PORT = port;
		this.SERVER_ROOT = root;
		this.SERVER_HOMEPAGE = defaultPage;
		this.SERVER_ICONS = icon;
		this.SERVER_LOG = logPath;
	}

	public void GeneralInfos() {
		// Method GeneralInfos collecting some System Informations

		// Getting The System User Connected informations
		String USER_HOME = System.getProperty("user.home");
		String USER_NAME = System.getProperty("user.name");
		String USER_TIMEZONE = System.getProperty("user.timezone");
		String USER_DIR = System.getProperty("user.dir");

		// Getting The Operating System informations
		String OS_NAME = System.getProperty("os.name");
		String OS_ARCH = System.getProperty("os.arch");
		String OS_VERS = System.getProperty("os.version");

		System.out.println("[PLATFORM]");
		System.out.println("\t|_NAME=" + OS_NAME + "");
		System.out.println("\t|_VERSION=" + OS_VERS + "");
		System.out.println("\t|_ARCHITECTURE=" + OS_ARCH + "");

		System.out.println("\n");

		System.out.println("[USER]");
		System.out.println("\t|_NAME=" + USER_NAME + "");
		System.out.println("\t|_HOME_DIRECTORY=" + USER_HOME + "");
		System.out.println("\t|_USER_DIR=" + USER_DIR + "");
		System.out.println("\t|_TIMEZONE=" + USER_TIMEZONE + "");
	}

	public void run() throws IOException {
		try {
			// creating a new ServerSocket Listening on SERVER_PORT
			ServerSocket S = new ServerSocket(this.SERVER_PORT);

			try {
				while (true) {
					// returning an established socket via the ServerSocket accept method
					Socket socket = S.accept();

					try {
						System.out.println("[REMOTE HOST]: " + socket.getInetAddress().toString());
						System.out.println("[LISTNING ON PORT]: " + socket.getPort());
						// calling the ServeurWeb constructor
						new WebServer(socket, SERVER_ROOT, SERVER_HOMEPAGE, SERVER_ICONS, SERVER_LOG);

					} catch (IOException e) {
						socket.close();// always close the socket
					}
				}
			} finally {
				S.close(); // always close the ServerSocket
			}
		} catch (BindException B) {
			// handling exception generated if they are already running server
			System.out.println("SERVER Already Running");
			System.exit(0);
		}
	}

}
