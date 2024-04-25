package revMetrix.controller;

import java.util.ArrayList;

import java.util.List;

import revMetrix.db.model.Account;
import revMetrix.db.persist.DatabaseProvider;
import revMetrix.db.persist.DerbyDatabase;
import revMetrix.db.persist.IDatabase;

public class AllAccountsController {

	private IDatabase db = null;

	public AllAccountsController() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
	}

	public ArrayList<Account> getAllAccounts() {
		
		
		List<Account> accountList = db.findAllAccounts();
		ArrayList<Account> accounts = null;
		
		if (accountList.isEmpty()) {
			System.out.println("No accounts found");
			return null;
		}
		else {
			accounts = new ArrayList<Account>();
			for (Account account : accountList) {
				accounts.add(account);
				System.out.println(account.getEmail() + ", " + account.getPassword() + ", "+ account.getFirstname() + ", " + account.getLastname() + ", " + account.isLoggedIn());
			}			
		}
		
		return accounts;
	}
}

