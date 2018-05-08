package cn.zhumingwu.dms.dao;

public class Member {
	private String name;
	private int gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return this.name + this.gender;
	}
}
