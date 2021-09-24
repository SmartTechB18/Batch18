package com.testNGbasics;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	
	@BeforeTest
	public void getAB() {
		System.out.println("I am BT");
	}
	
	@AfterTest
	public void getABC() {
		System.out.println("I am AT");
	}
	
	@Test(priority = 1)
	public void getSalary() {
		System.out.println("My salary is $100");
	}
	
	@Test(priority = 1, dependsOnMethods= {"TestNGAnnotations.getA"})
	public void getB() {
		System.out.println("I am B");
	}
	
	@Test(priority = 5)
	public void getA() {
		System.out.println("I am A");
	}
	
	@Test(priority = 4)
	public void getC() {
		System.out.println("I am C");
	}
	
	@Test(priority = 5)
	public void getAdd() {
		System.out.println("I live in earth.");
	}

}
