package revMetrix.controller;

import revMetrix.db.persist.DatabaseProvider;

import revMetrix.db.persist.DerbyDatabase;
import revMetrix.db.persist.IDatabase;

public class InsertAccountController {

	private IDatabase db = null;

	public InsertAccountController() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
	}

	public boolean insertAccount(String email, String password, String lastName, String firstName) {
		
		// insert new book (and possibly new author) into DB
		Integer account_id = db.insertAccountIntoAccountsTable(email, password, lastName, firstName);

		// check if the insertion succeeded
		if (account_id > 0)
		{
			System.out.println("New Account (ID: " + account_id + ") successfully added to Accounts table: <" + email + ">");
			
			return true;
		}
		else
		{
			System.out.println("Failed to insert new account (ID: " + account_id + ") into Accounts table: <" + email + ">");
			
			return false;
		}
	}
}
