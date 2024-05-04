package revMetrix.db.model;

public class Practice extends Event {
    private int numberOfSessions; // Adding a specific attribute for Practice

    // Constructor
    public Practice(int eventId, int type, int establishmentId, String name, String description, String establishmentName, int numberOfSessions) {
        super();
        this.numberOfSessions = numberOfSessions;
    }

    // Getter and setter for numberOfSessions
    public void setNumberOfSessions(int numberOfSessions) {
        this.numberOfSessions = numberOfSessions;
    }

    public int getNumberOfSessions() {
        return numberOfSessions;
    }
}
