package revMetrix.db;

import java.util.List;

import java.util.Scanner;

import revMetrix.db.model.Account;
import revMetrix.db.persist.DatabaseProvider;
import revMetrix.db.persist.IDatabase;

public class AllAccountsQuery {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase.init(keyboard);
		
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		List<Account> accountList = db.findAllAccounts();
		
		// check if anything was returned and output the list
		if (accountList.isEmpty()) {
			System.out.println("There are no accounts in the database");
		}
		else {
			for (Account account : accountList) {
				System.out.println(account.getEmail() + ", " + account.getPassword() + ", "+ account.getFirstname() + ", " + account.getLastname() + ", " + account.isLoggedIn());
			}
		}
	}
}
