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
		System.out.println("Print value of s1"+s1+s2+s2);
	}
	
	public BookServiceImpl(String s1, String s2,String s3) {
		//3 Parametrized constructor.
		System.out.println("Print value of s1"+s1+s2+s2);
		System.out.println("One changes added from local server at 26Feb2024At12:558AM");
		System.out.println("One changes added from local server at 26Feb2024At11:32PM");
	}
	
	public void buyBook() {
		System.out.println("buyBook method added from local server at 27Feb2024At11:01PM");
	}

}
