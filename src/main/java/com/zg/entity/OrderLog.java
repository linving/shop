package com.zg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
* @author gez
* @version 0.1
*/

@Entity
public class OrderLog extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7530381132359990139L;
	
	public enum OrderLogType {
		CREATE, MODIFY, PAYMENT, REFUND, SHIPPING, RESHIP, COMPLETED, INVALID
	}
	
	private OrderLogType orderLogType;
	
	private String orderSn;
	
	private String operator;
	
	private String info;
	
	private Order order;

	@Enumerated
	@Column(nullable = false, updatable = false)
	public OrderLogType getOrderLogType() {
		return orderLogType;
	}

	public void setOrderLogType(OrderLogType orderLogType) {
		this.orderLogType = orderLogType;
	}

	@Column(nullable = false, updatable = false)
	public String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	@Column(updatable = false)
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Column(updatable = false, length = 5000)
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	

}
