package revMetrix.model;

import java.util.ArrayList;

public class RevMetrix {
    private ArrayList<String> AccountsList;
    private ArrayList<String> GamesList;
    
    public RevMetrix() {
    	AccountsList = new ArrayList<>();
    	GamesList = new ArrayList<>();
    }
    
    public ArrayList<String> getAccountList() {
        return AccountsList;
    }
    public ArrayList<String> getGamesList() {
        return GamesList;
    }

    public void setAccountsList(String account) {
        this.AccountsList.add(account);
    }
    public void setGamesList(String game) {
        this.GamesList.add(game);
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }
}
