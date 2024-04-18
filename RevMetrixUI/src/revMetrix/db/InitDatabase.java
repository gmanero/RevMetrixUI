package revMetrix.db;

import java.util.Scanner;


import revMetrix.db.persist.DatabaseProvider;
import revMetrix.db.persist.DerbyDatabase;

public class InitDatabase {
	public static void init(Scanner keyboard) {
		System.out.print("Type 1 for derby database: ");
		int which = Integer.parseInt(keyboard.nextLine());
		if (which == 1) {
			DatabaseProvider.setInstance(new DerbyDatabase());
		}else {
			throw new IllegalArgumentException("Invalid choice: " + which);
		}
	}
}
