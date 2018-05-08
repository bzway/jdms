package cn.zhumingwu.dms;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudApplication.class, args);
	}

	private static void run() {
		// creating an instance of type JavaWebServer
		JavaWebServer jwd = new JavaWebServer();

		try {
			jwd.GeneralInfos();
			System.out.println("run...\n");
			jwd.run();
			System.out.println("Shutdown\n");
		} catch (IOException ex) {
		}
	}
}