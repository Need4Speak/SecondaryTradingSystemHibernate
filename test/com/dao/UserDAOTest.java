package com.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import com.entity.User;

public class UserDAOTest {
	UserDAO userDAO = new UserDAO();

	@Test
	public void testGetAllUsers() {
		ArrayList<User> usersList = (ArrayList<User>) userDAO.findAll();
		Iterator<User> usersListIterator = usersList.iterator();
		User eachUser;
		while (usersListIterator.hasNext()) {
			eachUser = (User) usersListIterator.next();
			System.out.println(eachUser);
		}
	}

	/**
	 * sysout user info whose id=2.
	 */
	@Test
	public void testGetUserById() {
		System.out.println(userDAO.findById(2));
	}

	@Test
	public void testGetUserByName() {
		System.out.println(userDAO.findByUserName("user3"));
	}
	
	@Test
	public void testTryLogin() {
		assertTrue(userDAO.tryLogin("user1", "111"));
		//assertTrue(userDAO.tryLogin("user1", "222"));
		//assertTrue(userDAO.tryLogin("user10", "111"));
	}
}
