package learning.java.spring.springboot.controller.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	
	private String id;
	
	private String name;
	// 如果为空则不返回
	@JsonInclude(Include.NON_NULL)
	private String age;
	
	// 序列化成JSON时起别名
	@JsonProperty("username")
	private String account;
	
	// 序列化时忽略该值
	@JsonIgnore
	private String pwd;
	
	// 指定序列化格式
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
	private Date createTime;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public User(String id, String name, String age, String account, String pwd, java.util.Date date) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.account = account;
		this.pwd = pwd;
		this.createTime = date;
	}
	
}
