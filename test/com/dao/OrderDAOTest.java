package com.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.entity.Order;

public class OrderDAOTest {

	@Test
	public void testSave() {
		OrderDAO orderDAO = new OrderDAO();
		Order order = new Order(1,1, 2);
		orderDAO.save(order);
	}

}
