package com.factorymethod2;

public class TexasAccount extends BankAccount {

	@Override
	public double calculateTax() {
		return 0.0;
	}

}
