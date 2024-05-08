package revMetrix.db;

import java.util.List;


import java.util.Scanner;

import revMetrix.db.model.Establishment;
import revMetrix.db.persist.DatabaseProvider;
import revMetrix.db.persist.IDatabase;

public class allEstablishments {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase.init(keyboard);
		
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		
		List<Establishment> establishmentList = db.findAllEstablishments();
		
		// check if anything was returned and output the list
		if (establishmentList.isEmpty()) {
			System.out.println("There are no accounts in the database");
		}
		else {
			for (Establishment establishment : establishmentList) {
				System.out.println(establishment.getName() + ", " + establishment.getAddress() + ", "+ establishment.getPhoneNumber() + ", " + establishment.getLanes() + ", " + establishment.getEstablishmentId());
			}
		}
	}
}
