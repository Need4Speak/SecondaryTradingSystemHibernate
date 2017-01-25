package com.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import com.entity.Good;

public class GoodsDAOTest {
	GoodDAO goodDAO = new GoodDAO();
	@Test
	public void testGetAllGoods() {
		
		ArrayList<Good> goodsList = (ArrayList<Good>) goodDAO.findAll();
		Iterator<Good> goodsListIterator = goodsList.iterator();
		Good each_good;
        while(goodsListIterator.hasNext()){
        	each_good = (Good) goodsListIterator.next();
            System.out.println(each_good);
        }
	}
	
	@Test
	public void testGetGoodsById(){
		Good aGood = goodDAO.findById(2);
		System.out.println(aGood);
	}
}
