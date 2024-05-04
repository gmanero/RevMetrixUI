package revMetrix.db;

import java.util.List;
import java.util.Scanner;

import revMetrix.db.model.Session;
import revMetrix.db.persist.DatabaseProvider;
import revMetrix.db.persist.IDatabase;

public class findAllSessions {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

        // Create the default IDatabase instance
        InitDatabase.init(keyboard);

        // get the DB instance and execute transaction
        IDatabase db = DatabaseProvider.getInstance();

        List<Session> sessionList = db.findAllSessions();

        // check if anything was returned and output the list
        if (sessionList.isEmpty()) {
            System.out.println("There are no sessions in the database");
        } else {
            for (Session session : sessionList) {
                System.out.println("Session ID: " + session.getSessionId() + ", Event ID: " + session.getEventId() +
                        ", Score: " + session.getSessionScore() + ", Lanes: " + session.getLanes() +
                        ", Date: " + session.getDate() + ", User ID: " + session.getUserId());
            }
        }
    }
}
