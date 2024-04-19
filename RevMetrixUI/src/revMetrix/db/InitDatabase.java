package revMetrix.db;

import java.util.Scanner;


import revMetrix.db.persist.DatabaseProvider;
import revMetrix.db.persist.DerbyDatabase;

public class InitDatabase {
	public static void init(Scanner keyboard) {
			DatabaseProvider.setInstance(new DerbyDatabase());
		}
}
