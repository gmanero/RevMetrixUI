package revMetrix.controller;

import java.util.List;
import revMetrix.db.model.Establishment;
import revMetrix.db.persist.DatabaseProvider;
import revMetrix.db.persist.IDatabase;
import revMetrix.db.persist.DerbyDatabase;

public class EstablishmentController {

    private IDatabase db = null;

    public EstablishmentController() {
        // Creating DB instance here
        DatabaseProvider.setInstance(new DerbyDatabase());
        db = DatabaseProvider.getInstance();
    }

    public List<Establishment> getAllEstablishments() {
        return db.findAllEstablishments();
    }

    public Integer insertEstablishmentIntoEstablishmentsTable(String name) {
        return db.insertEstablishmentIntoEstablishmentsTable(name);
    }
}
