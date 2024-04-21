package revMetrix.db;

import java.util.Scanner;

import revMetrix.db.persist.DatabaseProvider;
import revMetrix.db.persist.IDatabase;

public class InsertNewEventQuery {

    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

        // Create the default IDatabase instance
        InitDatabase.init(keyboard);

        System.out.print("Enter Establishment Name: ");
        String establishmentName = keyboard.nextLine();

        System.out.print("Enter Event Name: ");
        String eventName = keyboard.nextLine();

        System.out.print("Enter Description: ");
        String description = keyboard.nextLine();

        System.out.print("Enter Event Type (practice/league/tournament): ");
        String eventType = keyboard.nextLine();

        // get the DB instance and execute the transaction
        IDatabase db = DatabaseProvider.getInstance();
        Integer eventId = db.insertEventWithEstablishmentNameAndType(establishmentName, eventName, description, eventType);

        // check if the insertion succeeded
        if (eventId > 0) {
            System.out.println("New Event (ID: " + eventId + ") successfully added to Events table: " + eventName);
        } else {
            System.out.println("Failed to insert new Event (ID: " + eventId + ") into Events table: " + eventName);
        }
    }
}
