package revMetrix.db.model;

public class Event {
    private int eventId;
    private int type;
    private int establishmentId;
    private String name;
    private String description;
    private String establishmentName;

    // Constructor
    public Event() {
    }

    // Getters and setters
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setEstablishmentId(int establishmentId) {
        this.establishmentId = establishmentId;
    }

    public int getEstablishmentId() {
        return establishmentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getEstablishmentName() {
        return establishmentName;
    }

    public void setEstablishmentName(String establishmentName) {
        this.establishmentName = establishmentName;
    }

    public String getTypeString() {
        switch (type) {
            case 1:
                return "Practice";
            case 2:
                return "League";
            case 3:
                return "Tournament";
            default:
                return "Unknown";
        }
    }
}
