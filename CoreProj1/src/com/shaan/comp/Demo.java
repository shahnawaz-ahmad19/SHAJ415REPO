package com.shaan.comp;

public class Demo {
     private int a=10,b=20;
     
     public Demo() {
		System.out.println("Demo:: 0-param constructor");
	}
     
     

	public Demo(int a, int b) {
		this.a = a;
		this.b = b;
		System.out.println("Demo:: 2-param constructor");
	}



	@Override
	public String toString() {
		return "Demo [a=" + a + ", b=" + b + "]";
	}
     
     
}
