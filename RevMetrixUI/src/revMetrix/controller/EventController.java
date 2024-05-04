package revMetrix.controller;

import revMetrix.db.model.Event;
import revMetrix.db.model.Game;
import revMetrix.db.model.Establishment;
import revMetrix.db.persist.DatabaseProvider;
import revMetrix.db.persist.DerbyDatabase;
import revMetrix.db.persist.IDatabase;

import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<Event> getAllPracticeEvents() {
        List<Event> practiceEventList = db.findAllPracticeEvents();
        List<Establishment> establishmentList = db.findAllEstablishments(); // Fetch all establishments

        ArrayList<Event> practiceEvents = new ArrayList<>();

        if (practiceEventList.isEmpty()) {
            System.out.println("No practice events found");
            return practiceEvents;
        } else {
            for (Event event : practiceEventList) {
                // Set establishment name for each practice event
                event.setEstablishmentName(getEstablishmentName(event.getEstablishmentId(), establishmentList));
                practiceEvents.add(event);
                System.out.println("Practice Event Name: " + event.getName() + ", Establishment: " +
                        event.getEstablishmentName() +
                        ", Description: " + event.getDescription());
            }
        }

        return practiceEvents;
    }

    public ArrayList<Event> getAllLeagueEvents() {
        List<Event> leagueEventList = db.findAllLeagueEvents();
        List<Establishment> establishmentList = db.findAllEstablishments(); // Fetch all establishments

        ArrayList<Event> leagueEvents = new ArrayList<>();

        if (leagueEventList.isEmpty()) {
            System.out.println("No league events found");
            return leagueEvents;
        } else {
            for (Event event : leagueEventList) {
                // Set establishment name for each league event
                event.setEstablishmentName(getEstablishmentName(event.getEstablishmentId(), establishmentList));
                leagueEvents.add(event);
                System.out.println("League Event Name: " + event.getName() + ", Establishment: " +
                        event.getEstablishmentName() +
                        ", Description: " + event.getDescription());
            }
        }

        return leagueEvents;
    }

    public ArrayList<Event> getAllTournaments() {
        List<Event> tournamentList = db.findAllTournaments();
        List<Establishment> establishmentList = db.findAllEstablishments(); // Fetch all establishments

        ArrayList<Event> tournaments = new ArrayList<>();

        if (tournamentList.isEmpty()) {
            System.out.println("No tournaments found");
            return tournaments;
        } else {
            for (Event event : tournamentList) {
                // Set establishment name for each tournament
                event.setEstablishmentName(getEstablishmentName(event.getEstablishmentId(), establishmentList));
                tournaments.add(event);
                System.out.println("Tournament Name: " + event.getName() + ", Establishment: " +
                        event.getEstablishmentName() +
                        ", Description: " + event.getDescription());
            }
        }

        return tournaments;
    }

	public ArrayList<Event> findEventByID(int eventId) {
    List<Event> eventList = db.findEventById(eventId);
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
	
	private int eventId = -1;
	public int findEventIdByInfo(String name, String description) {
		eventId = db.findEventIdByInfo(name, description);
		return eventId;
	}
	public void updateSessionScore(int id) {
		ArrayList<Game> games = db.GetGamesBySession(id);
		int total = 0;
		for(Game game:games) {
			total+= game.getGameScore();
		}
		db.updateSessionScore(id, total);
		
	}
	
	}