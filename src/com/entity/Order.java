package com.entity;

import java.util.Date;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Integer goodId;
	private Integer buyerId;
	private Integer sellerId;
	private Date creationTime;
	private Date cancelTime;
	private String status;
	private String deliveryAddress;
	private Double freight;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** minimal constructor */
	public Order(Integer goodId, Integer buyerId, Integer sellerId) {
		this.goodId = goodId;
		this.buyerId = buyerId;
		this.sellerId = sellerId;
	}

	public Order(Integer goodId, Integer buyerId, Integer sellerId,
			Date creationTime, Double freight) {
		super();
		this.goodId = goodId;
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.creationTime = creationTime;
		this.freight = freight;
	}

	/** full constructor */
	public Order(Integer goodId, Integer buyerId, Integer sellerId,
			Date creationTime, Date cancelTime, String status,
			String deliveryAddress, Double freight) {
		this.goodId = goodId;
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.creationTime = creationTime;
		this.cancelTime = cancelTime;
		this.status = status;
		this.deliveryAddress = deliveryAddress;
		this.freight = freight;
	}

	// Property accessors

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", goodId=" + goodId + ", buyerId="
				+ buyerId + ", sellerId=" + sellerId + ", creationTime="
				+ creationTime + ", cancelTime=" + cancelTime + ", status="
				+ status + ", freight=" + freight + "]";
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getGoodId() {
		return this.goodId;
	}

	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}

	public Integer getBuyerId() {
		return this.buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public Integer getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public Date getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getCancelTime() {
		return this.cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeliveryAddress() {
		return this.deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Double getFreight() {
		return this.freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

}