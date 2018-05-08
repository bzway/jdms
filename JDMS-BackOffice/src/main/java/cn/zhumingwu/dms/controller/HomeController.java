package cn.zhumingwu.dms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.bzway.dms.dao.mybatis.UserMapper;

@Service
@Controller
public class HomeController {

	//@Autowired
	//private UserMapper accountMapper;

	@RequestMapping("/")
	@ResponseBody
	public Object index() {
		return "test";
        //return this.accountMapper.selectAll().size();
	}
}
