package com.entity;

import java.util.Date;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class OrderDetial implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private String goodName;
	private String buyerName;
	private String sellerName;
	private Date creationTime;
	private Date cancelTime;
	private String status;
	private String deliveryAddress;
	private Double freight;

	public OrderDetial() {
		super();
	}

	public OrderDetial(Integer orderId, String goodName, String buyerName,
			String sellerName, Date creationTime, Double freight) {
		super();
		this.orderId = orderId;
		this.goodName = goodName;
		this.buyerName = buyerName;
		this.sellerName = sellerName;
		this.creationTime = creationTime;
		this.freight = freight;
	}

	public OrderDetial(Integer orderId, String goodName, String buyerName,
			String sellerName, Date creationTime, Date cancelTime,
			String status, String deliveryAddress, Double freight) {
		super();
		this.orderId = orderId;
		this.goodName = goodName;
		this.buyerName = buyerName;
		this.sellerName = sellerName;
		this.creationTime = creationTime;
		this.cancelTime = cancelTime;
		this.status = status;
		this.deliveryAddress = deliveryAddress;
		this.freight = freight;
	}

	@Override
	public String toString() {
		return "OrderDetial [orderId=" + orderId + ", goodName=" + goodName
				+ ", buyerName=" + buyerName + ", sellerName=" + sellerName
				+ ", creationTime=" + creationTime + ", status=" + status
				+ ", freight=" + freight + "]";
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

}