package revMetrix.db.persist;

import java.util.List;


import revMetrix.db.model.*;

public interface IDatabase {
	public List<Account> findAllAccounts();
	public Integer insertAccountIntoAccountsTable(String email, String password, String lastName, String firstName);
	public Integer insertEventWithEstablishmentNameAndType(final String establishmentName, final String eventName, final String description, final String eventType);
	public List<Event> findAllEvents();
	public Establishment findEstablishmentById(int establishmentId);
	public List<Establishment> findAllEstablishments();
}
