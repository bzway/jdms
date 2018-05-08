package cn.zhumingwu.dms.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController {
	@RequestMapping("user")
	public String home() {
		return "account/user" + name;
	}

	@Value("${server.port}")
	private String name;
}
