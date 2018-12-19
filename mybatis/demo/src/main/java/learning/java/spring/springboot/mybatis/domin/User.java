package learning.java.spring.springboot.mybatis.domin;

import java.util.Date;

public class User {
	
	private int id;
	
	private String name;
	
	private String phone;
	
	private int age;
	
	private Date createTime;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public int getAge() {
		return age;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
