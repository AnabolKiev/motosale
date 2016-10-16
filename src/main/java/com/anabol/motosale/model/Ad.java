package com.anabol.motosale.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Ad")
public class Ad {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, precision = 5, scale = 0)
    private Long id;
    @Column(name = "TITLE", nullable = true, length = 255)
    private String title;
    @Column(name = "DESCRIPTION", nullable = true, length = 2048)
    private String description;
    @Column(name = "MANUFACTURERID", nullable = true)
    private Integer manufacturerId;
    @Column(name = "MODELID", nullable = true)
    private Integer modelId;
    @Column(name = "PRODUCEYEAR", nullable = true)
    private Integer produceYear;
    @Column(name = "CAPACITY", nullable = true)
    private Integer capacity;
    @Column(name = "MILEAGE", nullable = true)
    private Integer mileage;
    @Column(name = "PHONE", nullable = true, length = 15)
    private String phone;
    @Column(name = "EMAIL", nullable = true, length = 30)
    private String email;
    @Temporal(TemporalType.DATE)
    @Column(name = "STARTDATE", nullable = true, length = 7)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "ENDDATE", nullable = true, length = 7)
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

public Integer getManufacturerId() {
	return manufacturerId;
}

public void setManufacturerId(Integer manufacturerId) {
	this.manufacturerId = manufacturerId;
}

public Integer getModelId() {
	return modelId;
}

public void setModelId(Integer modelId) {
	this.modelId = modelId;
}

public Integer getProduceYear() {
	return produceYear;
}

public void setProduceYear(Integer year) {
	this.produceYear = year;
}

public Integer getCapacity() {
	return capacity;
}

public void setCapacity(Integer capacity) {
	this.capacity = capacity;
}

public Integer getMileage() {
	return mileage;
}

public void setMileage(Integer mileage) {
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

/*public Ad(String title, String description, int manufacturerId, int modelId, int year, int capacity,
		int mileage, String phone, String email, Date startDate, Date endDate) {
	super();
	this.title = title;
	this.description = description;
	this.manufacturerId = manufacturerId;
	this.modelId = modelId;
	this.produceYear = year;
	this.capacity = capacity;
	this.mileage = mileage;
	this.phone = phone;
	this.email = email;
	this.startDate = startDate;
	this.endDate = endDate;
}*/
/*
public Ad() {
	super();
	// TODO Auto-generated constructor stub
}
 */
}