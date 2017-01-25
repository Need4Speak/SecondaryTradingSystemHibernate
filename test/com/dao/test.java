package com.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class test {
	public static void main(String[] args) {
//		String string = "aa";
//		String[] strings = string.split(", ");
//		System.out.println(strings[0]);
//		System.out.println(strings[1]);
        String[] words = {"ace", "boom", "crew", "dog", "eon"};  
        List<String> myList = new ArrayList<String>();
        Collections.addAll(myList, words);
        List<String> wordList = Arrays.asList(words);  
        
        myList.add("a");
        for (String e : myList){  
            System.out.println(e);  
        }
	}
}