package com.hm.pojo;

import java.util.Date;

//房间分类表
public class Fenlei {
	@Override
	public String toString() {
		return "Fenlei{" +
				"id=" + id +
				", leixing='" + leixing + '\'' +
				", jiage=" + jiage +
				", deletestatus=" + deletestatus +
				", createtime=" + createtime +
				'}';
	}

	private int id;//主键
	
	private String leixing;//房间类型
	
	private double jiage;//房间价格
	
	private int deletestatus;//房间类型对应的状态 0表示正常状态 1表示删除状态
	
	private Date createtime;//添加时间
	
	
	

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLeixing() {
		return leixing;
	}

	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}

	public double getJiage() {
		return jiage;
	}

	public void setJiage(double jiage) {
		this.jiage = jiage;
	}

	public int getDeletestatus() {
		return deletestatus;
	}

	public void setDeletestatus(int deletestatus) {
		this.deletestatus = deletestatus;
	}
	
	
	

	
}
