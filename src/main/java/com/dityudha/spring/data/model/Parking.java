package com.dityudha.spring.data.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")

public class Parking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "registno")
	private String registno;
	@Column(name = "arrival")
	private String arrival;
	@Column(name = "deprature")
	private String deprature;
	@Column(name = "status")
	private String status;
	@Column(name = "bill")
	private String bill;

//	public Parking(String registno, String arrival, boolean b) {
//		this.registno = registno;
//		this.arrival = arrival;
//		this.deprature = deprature;
//		this.status = status;
//		this.bill = bill;
//	}

	public Parking() {

	}

	public Parking(String registno, String arrival, String deprature, String status, String bill, boolean b) {
		this.registno = registno;
		this.arrival = arrival;
		this.deprature = deprature;
		this.status = status;
		this.bill = bill;
	}

//	public Parking(String registno, String arrival, boolean b) {
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRegistno() {
		return registno;
	}

	public void setRegistno(String registno) {
		this.registno = registno;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDeprature() {
		return deprature;
	}

	public void setDeprature(String deprature) {
		this.deprature = deprature;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBill() {
		return bill;
	}

	public void setBill(String bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "Parking{" + "id=" + id + ", registno='" + registno + '\'' + ", arrival='" + arrival + '\'' + ", deprature='" + deprature + '\'' + ", status='" + status + '\'' + ", bill='" + bill + '\'' + '}';
	}


	//	public Parking(String brand, String type, boolean sold) {
//		this.brand = brand;
//		this.type = type;
//		this.sold = sold;
//	}
	
//	public long getId() {
//	return id;
//	}
//	public String getBrand() {
//		return brand;
//	}
//	public void setBrand(String brand) {
//		this.brand = brand;
//	}
//	public String getType() {
//		return type;
//	}
//	public void setType(String type) {
//		this.type = type;
//	}
//	public boolean isSold() {
//		return sold;
//	}
//	public void setSold(boolean isSold) {
//		this.sold = isSold;
//	}
//
//	@Override
//	public String toString() {
//		return "Tutorial [id=" + id + ", brand=" + brand + ", type=" + type + ", sold=" + sold + "]";
//	}

//	public long getId() {
//		return id;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	public boolean isPublished() {
//		return published;
//	}
//	public void setPublished(boolean isPublished) {
//		this.published = isPublished;
//	}
}