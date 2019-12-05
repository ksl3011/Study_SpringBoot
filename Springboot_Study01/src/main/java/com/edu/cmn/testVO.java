package com.edu.cmn;

import org.apache.ibatis.type.Alias;

@Alias("testVO")
public class testVO {

	private String a;
	private String b;
	private String c;
	
	public testVO(){}

	public testVO(String a, String b, String c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "testVO [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	
}
