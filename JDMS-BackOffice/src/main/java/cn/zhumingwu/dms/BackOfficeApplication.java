package cn.zhumingwu.dms;
 
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zhumingwu.dms.domain.User;
import cn.zhumingwu.dms.service.MessageService;

@SpringBootApplication
//@MapperScan("com.bzway.dms.dao.mybatis")
public class BackOfficeApplication implements CommandLineRunner {
 

	public static void main(String[] args) {
		SpringApplication.run(BackOfficeApplication.class, args);
		
		
    	//用我们的配置文件来启动一个 ApplicationContext
        //ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        //System.out.println("context 启动成功");

        // 从 context 中取出我们的 Bean，而不是用 new MessageServiceImpl() 这种方式
        //MessageService messageService = context.getBean(MessageService.class);
        
        // 这句将输出: hello world
        //System.out.println(messageService.getMessage());
        
        //User user =(User) context.getBean("user");
        //System.out.println(user.getUserName());
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
