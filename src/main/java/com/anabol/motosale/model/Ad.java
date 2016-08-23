package com.anabol.motosale.model;

import java.util.Date;

/**
 * Ёкземпл€р класса модели представл€ет собой одно объ€вление
 */
public class Ad {
 private Long id;
 private String title;
 private String description;
 private int manufacturerId;
 private int modelId;
 private int year;
 private int capacity;
 private int mileage;
 private String phone;
 private String email;
 private Date startDate;
 private Date endDate;
 
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getManufacturerId() {
	return manufacturerId;
}
public void setManufacturerId(int manufacturerId) {
	this.manufacturerId = manufacturerId;
}
public int getModelId() {
	return modelId;
}
public void setModelId(int modelId) {
	this.modelId = modelId;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public int getCapacity() {
	return capacity;
}
public void setCapacity(int capacity) {
	this.capacity = capacity;
}
public int getMileage() {
	return mileage;
}
public void setMileage(int mileage) {
	this.mileage = mileage;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Ad(String title, String description, int manufacturerId, int modelId, int year, int capacity,
		int mileage, String phone, String email, Date startDate, Date endDate) {
	super();
	this.title = title;
	this.description = description;
	this.manufacturerId = manufacturerId;
	this.modelId = modelId;
	this.year = year;
	this.capacity = capacity;
	this.mileage = mileage;
	this.phone = phone;
	this.email = email;
	this.startDate = startDate;
	this.endDate = endDate;
}
public Ad() {
	super();
	// TODO Auto-generated constructor stub
}
 
}