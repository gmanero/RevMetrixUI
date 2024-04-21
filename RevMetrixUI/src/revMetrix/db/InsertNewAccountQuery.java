package revMetrix.db;

import java.util.Scanner;

import revMetrix.db.persist.DatabaseProvider;
import revMetrix.db.persist.IDatabase;

public class InsertNewAccountQuery {

	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase.init(keyboard);

		System.out.print("Enter First Name: ");
		String firstName = keyboard.nextLine();
		
		System.out.print("Enter Last Name: ");
		String lastName = keyboard.nextLine();
		
		System.out.print("Enter Email: ");
		String email = keyboard.nextLine();
		
		System.out.print("Enter Password: ");
		String password = keyboard.nextLine();
		
		// get the DB instance and execute the transaction
		IDatabase db = DatabaseProvider.getInstance();
		Integer account_id = db.insertAccountIntoAccountsTable(email, password, lastName, firstName);

		// check if the insertion succeeded
		if (account_id > 0)
		{
			System.out.println("New Account (ID: " + account_id + ") successfully added to Accounts table: <" + password + ">");
		}
		else
		{
			System.out.println("Failed to insert new Account (ID: " + account_id + ") into Accounts table: <" + password + ">");			

		}
	}
}