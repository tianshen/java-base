package com.example.base.JAVA8_LAMBDA;

public class Hello {
	Runnable r1 = () -> { System.out.println(this); };
	// Runnable r2 = () -> { System.out.println(toString()); };
	public static void main(String[] args) {
		new Hello().r1.run();
		// new Hello().r2.run();
	}
	// public String toString() { return "Hello Hoolee"; }
}