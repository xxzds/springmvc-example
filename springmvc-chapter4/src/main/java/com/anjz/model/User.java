package com.anjz.model;

import java.util.Date;

import com.anjz.support.formatter.DateCusm;

public class User {

	private String username;
	private String password;
	
	
	@DateCusm("yyyy-MM-dd")
	private Date createTime;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
