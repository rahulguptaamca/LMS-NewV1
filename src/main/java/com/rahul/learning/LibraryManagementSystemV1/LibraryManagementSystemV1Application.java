package com.rahul.learning.LibraryManagementSystemV1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementSystemV1Application {

	public static void main(String[] args) {
		System.out.println("Hello main program started with one sysout changes done from remote server");
		System.out.println("Made changes add one line locally on main branch at 31May22-7-54PM");
		System.out.println("Made changes add one line from remote server on main branch at 31May22-7-55PM");
		System.out.println("Made changes add one line remotely on main branch at 1June22-12-21PM");
		SpringApplication.run(LibraryManagementSystemV1Application.class, args); 
	}

}
