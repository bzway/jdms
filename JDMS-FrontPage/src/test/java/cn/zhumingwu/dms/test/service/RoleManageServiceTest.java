package cn.zhumingwu.dms.test.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

import cn.zhumingwu.dms.service.RoleManageService;

public class RoleManageServiceTest {

	private static RoleManageService service;

	@BeforeClass
	public static void init() {
		ApplicationContext context = new AnnotationConfigApplicationContext();
		service = context.getBean(RoleManageService.class);
	}

	@Test
	public void testGetAcccountById() {
		try {
			long count = service.CountDataRow();
			Assert.isTrue(count > 0);
		} catch (Exception ex) {

		} finally {

		}
	}
}
