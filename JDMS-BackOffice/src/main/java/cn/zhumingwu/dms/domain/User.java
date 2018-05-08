package cn.zhumingwu.dms.domain;

import java.util.Date;

import javax.persistence.Table;

@Table
public class User extends BaseEntity {
 
	private String userName;

	private String password; 
	
	public User() {
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
