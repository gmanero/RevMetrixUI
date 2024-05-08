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

    public Integer insertEstablishmentIntoEstablishmentsTable(String name, String address, String phoneNumber, int lanes) {
        return db.insertEstablishmentIntoEstablishmentsTable(name, address, phoneNumber, lanes);
    }
    
    public void updateEstablishmentName(int establishmentId, String newName) {
        db.updateEstablishmentName(establishmentId, newName);
    }

    public void updateEstablishmentAddress(int establishmentId, String newAddress) {
        db.updateEstablishmentAddress(establishmentId, newAddress);
    }

    public void updateEstablishmentPhoneNumber(int establishmentId, String newPhoneNumber) {
        db.updateEstablishmentPhoneNumber(establishmentId, newPhoneNumber);
    }

    public void updateEstablishmentLanes(int establishmentId, int newLanes) {
        db.updateEstablishmentLanes(establishmentId, newLanes);
    }
}
