package com.hm.pojo;

import java.util.Date;
//用户
public class User {

	private int id;
	
	private String username;//用户名
	
	private String xingbie;//男 女  
	
	private String password;//密码
	
	private Date createtime;//添加时间

	private int role;//1表示管理员
	
	private String truename;//真实姓名
	
	private String lianxifangshi;//联系方式
	
	private int userlock;//用户状态 0表示正常状态 1表示删除状态

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", xingbie='" + xingbie + '\'' +
				", password='" + password + '\'' +
				", createtime=" + createtime +
				", role=" + role +
				", truename='" + truename + '\'' +
				", lianxifangshi='" + lianxifangshi + '\'' +
				", userlock=" + userlock +
				'}';
	}

	public int getUserlock() {
		return userlock;
	}

	public void setUserlock(int userlock) {
		this.userlock = userlock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getLianxifangshi() {
		return lianxifangshi;
	}

	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}

	public String getXingbie() {
		return xingbie;
	}

	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	

	
}
