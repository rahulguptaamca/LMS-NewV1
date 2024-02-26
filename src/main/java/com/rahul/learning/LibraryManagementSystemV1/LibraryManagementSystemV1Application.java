package com.rahul.learning.LibraryManagementSystemV1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementSystemV1Application {

	public static void main(String[] args) {
		System.out.println("Hello main program started with one sysout changes done from remote server");
		SpringApplication.run(LibraryManagementSystemV1Application.class, args); 
		System.out.println("*****************************************");
		System.out.println("One sysout changes added from local server at 26Feb2024At11:28PM");
		System.out.println("*****************************************");
		System.out.println("One sysout changes added from local server at 26Feb2024At11:30PM");
		System.out.println("*****************************************");
		System.out.println("One sysout changes added from local server at 26Feb2024At11:32PM");
	}

}
