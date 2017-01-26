package com.dao;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.entity.Good;
import com.entity.User;
import com.util.HibernateSessionFactory;

public class GoodDAOTest {

	@Test
	public void testSave() {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		
		User aUser = (User) session.get(User.class, 2);
		System.out.println(aUser);
		transaction.commit();
		HibernateSessionFactory.closeSession();
		
		Good aGood = new Good(aUser, "good10", 100.0, "10.jpg", 1.1);
		
		GoodDAO goodDAO = new GoodDAO();
		goodDAO.save(aGood); 
		

	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByProperty() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByPrice() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByPictures() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testMerge() {
		fail("Not yet implemented");
	}

	@Test
	public void testAttachDirty() {
		fail("Not yet implemented");
	}

	@Test
	public void testAttachClean() {
		fail("Not yet implemented");
	}

}
