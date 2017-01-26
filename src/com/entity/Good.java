package com.entity;

/**
 * Good entity. @author MyEclipse Persistence Tools
 */

public class Good implements java.io.Serializable {

	// Fields

	private Integer goodId;
	private User user;
	private String name;
	private Double price;
	private String pictures;
	private Double freight;

	// Constructors

	/** default constructor */
	public Good() {
	}

	/** minimal constructor */
	public Good(String name, Double price, String pictures, Double freight) {
		this.name = name;
		this.price = price;
		this.pictures = pictures;
		this.freight = freight;
	}
	
	
	public Good(User user, String name, Double price, String pictures) {
		super();
		this.user = user;
		this.name = name;
		this.price = price;
		this.pictures = pictures;
	}

	/** full constructor */
	public Good(User user, String name, Double price, String pictures,
			Double freight) {
		this.user = user;
		this.name = name;
		this.price = price;
		this.pictures = pictures;
		this.freight = freight;
	}

	// Property accessors

	public Integer getGoodId() {
		return this.goodId;
	}

	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPictures() {
		return this.pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

	public Double getFreight() {
		return this.freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

}