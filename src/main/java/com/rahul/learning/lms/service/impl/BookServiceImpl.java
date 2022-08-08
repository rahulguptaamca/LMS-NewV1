package com.rahul.learning.lms.service.impl;

public class BookServiceImpl {
	
	public BookServiceImpl() {
		//default constructor.
	}
	
	public BookServiceImpl(String s1) {
		//one Parametrized constructor.
		System.out.println("Print value of s1"+s1);
	}
	
	public BookServiceImpl(String s1, String s2) {
		//2 Parametrized constructor.
		System.out.println("Print value of s1"+s1+s2);
	}

}
