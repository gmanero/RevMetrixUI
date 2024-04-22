package revMetrix.db;

import java.util.List;
import java.util.Scanner;

import revMetrix.db.model.Event;
import revMetrix.db.persist.DatabaseProvider;
import revMetrix.db.persist.IDatabase;

public class getAllEvents {

    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

        // Create the default IDatabase instance
        InitDatabase.init(keyboard);
        
        // get the DB instance and execute transaction
        IDatabase db = DatabaseProvider.getInstance();
        List<Event> eventList = db.findAllEvents();
        
        // check if anything was returned and output the list
        if (eventList.isEmpty()) {
            System.out.println("There are no events in the database");
        } else {
            for (Event event : eventList) {
                System.out.println("Event ID: " + event.getEventId());
                System.out.println("Event Type: " + event.getType());
                System.out.println("Establishment ID: " + event.getEstablishmentId());
                System.out.println("Event Name: " + event.getName());
                System.out.println("Description: " + event.getDescription());
                // Add more fields if necessary
                System.out.println();
            }
        }
    }
}
