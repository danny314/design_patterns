package com.factorymethod2;

public class CaliforniaBranch extends BankBranch {

	@Override
	public BankAccount createAccount() {
		// TODO Auto-generated method stub
		return new CaliforniaAccount();
	}

}
