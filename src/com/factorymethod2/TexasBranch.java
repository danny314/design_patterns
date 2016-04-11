package com.factorymethod2;

public class TexasBranch extends BankBranch {

	@Override
	public BankAccount createAccount() {
		return new TexasAccount();
	}

}
