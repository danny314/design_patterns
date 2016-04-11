package com.decorator;

public class CaseDecorator {
	
	private MyStringReader myStringReader;
	
	public CaseDecorator(MyStringReader myStringReader) {
		this.myStringReader = myStringReader;
	}

	public String getLowerCase() {
		return this.myStringReader.readString().toLowerCase();
	}
	
	public static void main(String[] args) {
		MyStringReader caseConverter = new MyStringReader();
		String str = new CaseDecorator(caseConverter).getLowerCase();
		System.out.println(str);
	}
}
