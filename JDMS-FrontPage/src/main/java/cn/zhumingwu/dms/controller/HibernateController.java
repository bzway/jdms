package cn.zhumingwu.dms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zhumingwu.dms.dao.Member;
import cn.zhumingwu.dms.service.RoleManageService;

@Controller
@RequestMapping("/hibernate")
public class HibernateController {

	@Autowired
	RoleManageService roleManageService;

	@RequestMapping("/count")
	@ResponseBody()
	public long getDbType() {
		return this.roleManageService.CountDataRow();
	}

}
