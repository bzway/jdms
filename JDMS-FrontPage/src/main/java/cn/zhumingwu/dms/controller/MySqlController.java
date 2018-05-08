package cn.zhumingwu.dms.controller;
 
 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mysql")
public class MySqlController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping("/getUsers")
	@ResponseBody()
	public List<Map<String, Object>> getDbType() {
		String sql = "SELECT\r\n" + 
				"`user`.id AS Id,\r\n" + 
				"`user`.username AS UserName,\r\n" + 
				"`user`.`password` AS `Password`\r\n" + 
				"FROM\r\n" + 
				"`user`\r\n" + 
				"";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		 
		return list;
	}

}
