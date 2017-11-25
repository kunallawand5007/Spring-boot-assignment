/**
 * 
 */
package com.intellect.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author admin
 *
 */
@SpringBootApplication
@ComponentScan(basePackages="com.intellect")
public class UserServiceApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 SpringApplication.run(UserServiceApplication.class, args);
		System.out.println("application started");

	}

}
