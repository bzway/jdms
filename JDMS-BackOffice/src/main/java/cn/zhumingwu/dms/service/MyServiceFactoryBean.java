package cn.zhumingwu.dms.service;

import org.springframework.beans.factory.FactoryBean;

import cn.zhumingwu.dms.domain.User;

public class MyServiceFactoryBean implements FactoryBean<User> {

	private String userName;
	private String password;

	@Override
	public User getObject() throws Exception {
		return new User();
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}

	public boolean isSingleton() {
		return false;
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
