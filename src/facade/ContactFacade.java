package facade;

import business_logic.Contact;
import business_logic.LightContact;
import persistent.daos.ContactDAO;
import persistent.factories.DaoPostgresFactory;

import java.sql.ResultSet;
import java.util.*;

/**
 * 
 */
public class ContactFacade {

    private ContactDAO contactDao;
    private ArrayList<Contact> contactList;

    /**
     * Default constructor
     */
    public ContactFacade() {
        this.contactDao = DaoPostgresFactory.getInstance().createContactDAO();
    }

    /**
     * @param name 
     * @param phone 
     * @param place 
     * @param mail 
     * @return
     */
    public boolean addContact(String name, String phone, String place, String mail) {
        boolean state = this.contactDao.insert(name, phone, place, mail);
        return state;
    }

    /**
     * @param idC 
     * @param name 
     * @param phone 
     * @param place 
     * @param mail 
     * @return
     */
    public boolean updateContact(int idC, String name, String phone, String place, String mail) {
        // TODO implement here
        return false;
    }

    /**
     * @param idC 
     * @return
     */
    public boolean deleteContact(int idC) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public ArrayList<LightContact> getAllContact() {
        ResultSet result = this.contactDao.selectAll();
        return null;
    }

}