package com.factorymethod2;

public class TestBank {

	
	public static void main(String[] args) {
		
		BankBranch texasBranch = new TexasBranch();
		BankAccount texasAccount = texasBranch.createAccount();
		System.out.println(texasAccount.calculateTax());

		BankBranch californiaBranch = new CaliforniaBranch();
		BankAccount californiaAccount = californiaBranch.createAccount();
		System.out.println(californiaAccount.calculateTax());
	}

}
