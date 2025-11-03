package com.Practice.OrderService_Microservice;

import java.time.*;

public class OrderEntity {

	private Long orderId;
	private LocalDateTime OrderTime;
	
	public OrderEntity(Long orderId, LocalDateTime orderTime) {
		this.orderId = orderId;
		OrderTime = orderTime;
	}
	public OrderEntity() {
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public LocalDateTime getOrderTime() {
		return OrderTime;
	}
	public void setOrderTime(LocalDateTime orderTime) {
		OrderTime = orderTime;
	}
	
	
}
