package revMetrix.controller;

import revMetrix.db.persist.DatabaseProvider;

import revMetrix.db.persist.DerbyDatabase;
import revMetrix.db.persist.IDatabase;

public class InsertEventController {

    private IDatabase db = null;

    public InsertEventController() {
        
        // creating DB instance here
    	DatabaseProvider.setInstance(new DerbyDatabase());
        db = DatabaseProvider.getInstance();       
    }

    public boolean insertEvent(String establishmentName, String eventName, String description, String eventType) {
        
        // insert new event with establishment name and type into DB
        Integer eventId = db.insertEventWithEstablishmentNameAndType(establishmentName, eventName, description, eventType);

        // check if the insertion succeeded
        if (eventId > 0)
        {
            System.out.println("New Event (ID: " + eventId + ") successfully added to Events table: " + eventName);
            
            return true;
        }
        else
        {
            System.out.println("Failed to insert new Event (ID: " + eventId + ") into Events table: " + eventName);
            
            return false;
        }
    }
}
