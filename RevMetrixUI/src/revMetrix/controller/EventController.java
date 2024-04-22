package revMetrix.controller;

import java.util.ArrayList;
import java.util.List;

import revMetrix.db.model.Event;
import revMetrix.db.model.Establishment;
import revMetrix.db.persist.DatabaseProvider;
import revMetrix.db.persist.DerbyDatabase;
import revMetrix.db.persist.IDatabase;

public class EventController {

    private IDatabase db = null;

    public EventController() {
        // Creating DB instance here
        DatabaseProvider.setInstance(new DerbyDatabase());
        db = DatabaseProvider.getInstance();
    }

    public ArrayList<Event> getAllEvents() {
        List<Event> eventList = db.findAllEvents();
        List<Establishment> establishmentList = db.findAllEstablishments(); // Fetch all establishments

        ArrayList<Event> events = new ArrayList<>();

        if (eventList.isEmpty()) {
            System.out.println("No events found");
            return events;
        } else {
            for (Event event : eventList) {
                // Set establishment name for each event
                event.setEstablishmentName(getEstablishmentName(event.getEstablishmentId(), establishmentList));
                events.add(event);
                System.out.println("Event Name: " + event.getName() + ", Establishment: " +
                        event.getEstablishmentName() +
                        ", Type: " + eventTypeToString(event.getType()) +
                        ", Description: " + event.getDescription());
            }
        }

        return events;
    }

    private String getEstablishmentName(int establishmentId, List<Establishment> establishments) {
        for (Establishment establishment : establishments) {
            if (establishment.getEstablishmentId() == establishmentId) {
                return establishment.getName();
            }
        }
        return "Unknown Establishment";
    }

    private String eventTypeToString(int eventType) {
        switch (eventType) {
            case 1:
                return "Practice";
            case 2:
                return "League";
            case 3:
                return "Tournament";
            default:
                return "Unknown Type";
        }
    }
}
