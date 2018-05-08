package cn.zhumingwu.dms.domain;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {

	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	
	private long createDate;
	private long updateDate;
	private long createUser;
	private long updateUser;

	public long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	public long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(long createUser) {
		this.createUser = createUser;
	}

	public long getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(long updateDate) {
		this.updateDate = updateDate;
	}

	public long getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(long updateUser) {
		this.updateUser = updateUser;
	}

}
