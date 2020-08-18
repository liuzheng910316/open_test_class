package com.example.demo.model;

import javax.persistence.*;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="user")
public class User {
	int id;
	String name;
	String email;
	String mobile;
	@Length(min=6,max=16,message="密码长度在6-16位之间")
	String password;
	int type;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="mobile")
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="type")
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
