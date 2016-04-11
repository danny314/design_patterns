package com.decorator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MyStringReader {
	
	private String str = "no string";

	public String readString() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			str = in.readLine();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}
