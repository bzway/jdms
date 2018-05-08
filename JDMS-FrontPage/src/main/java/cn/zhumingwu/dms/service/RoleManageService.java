package cn.zhumingwu.dms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cn.zhumingwu.dms.dao.RoleRepository;

@Service
public class RoleManageService {

	@Autowired
	private RoleRepository roleRepository;

	public long CountDataRow() {
		return this.roleRepository.count();
	}

}
