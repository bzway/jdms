package cn.zhumingwu.dms;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;





import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
@EnableJpaRepositories("com.bzway.dms.dao")
@MapperScan("com.bzway.dms.dao.mybatis")
@EntityScan("com.bzway.dms.model")
public class FrontPageApplication implements CommandLineRunner {
	
	  private static final Logger logger = LoggerFactory.getLogger(FrontPageApplication.class);

	@Autowired
	DataSource dataSource;

	public static void main(String[] args) {
		String message = "Test";
		logger.debug(message);
		logger.info(message);
		logger.warn(message);
		logger.error(message);
		logger.trace(message);
		SpringApplication.run(FrontPageApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
