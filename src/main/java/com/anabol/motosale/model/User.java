package com.anabol.motosale.model;

import java.util.Date;

/**
 * Ёкземпл€р класса модели представл€ет собой одного пользовател€.
 */
public class User {
 private Long id;
 private String login;
 private String name;
 private String email;
 private Date birthDate;
 
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getBirthDate() {
	return birthDate;
}
public void setBirthDate(Date birthDate) {
	this.birthDate = birthDate;
}

public User(String login, String name, String email, Date birthDate) {
	super();
	this.login = login;
	this.name = name;
	this.email = email;
	this.birthDate = birthDate;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
 
}