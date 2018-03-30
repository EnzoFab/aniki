package facade;

import business_logic.Contact;
import business_logic.LightContact;
import business_logic.User;
import persistent.daos.ContactDAO;
import persistent.factories.DaoFactory;
import persistent.factories.DaoPostgresFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 */
public class ContactFacade {

    private ContactDAO contactDao;
    private ArrayList<Contact> contactList;

    private final User connectedUser;

    /**
     * Default constructor
     */
    public ContactFacade(User user) {
        connectedUser = user;
        DaoFactory factory = DaoPostgresFactory.getInstance();
        this.contactDao = factory.createContactDAO();
        this.contactList = new ArrayList<>();
        try {
            this.getAllContacts();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param name 
     * @param phone 
     * @param place 
     * @param mail 
     * @return
     */
    public boolean addContact(String name, String first_name, String place, String mail, String phone) throws SQLException {
        Contact contact = new Contact(name, first_name, place, mail, phone);
        boolean state = this.contactDao.insert(name, first_name, place, mail, phone);

        if (state) {
            // If the insert is ok, we get the id given by the database and add it to the java object before inserted it in the arrayList
            int idC = (int) this.contactDao.selectLast().getObject("contact_id");
            contact.setIdC(idC);
            this.contactList.add(contact);
        }
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
    public boolean updateContact(int idC, String name, String first_name, String phone, String place, String mail) {
        //idC is the index of the event in the arrayList, not his real id in the database
        boolean state = this.contactDao.update(idC, name, first_name, phone, place, mail);
        if (state){
            this.contactList.get(idC).setFirstName(first_name);
            this.contactList.get(idC).setName(name);
            this.contactList.get(idC).setMail(mail);
            this.contactList.get(idC).setPhoneNumber(phone);
            this.contactList.get(idC).setPlace(place);
        }
        return state;
    }

    /**
     * @param idC 
     * @return
     */
    public boolean deleteContact(int idC) {
        // idC is the index of the event in the arrayList
        boolean state = this.contactDao.delete(this.contactList.get(idC).getIdC());
        if (state){
            this.contactList.remove(idC);
            System.out.println("Taille liste : "+this.contactList.size());
        }
        return state;
    }

    public boolean deleteLink(int idC, String team_name) {
        Contact contact = this.contactList.get(idC);
        boolean state = this.contactDao.deleteLink(contact.getIdC(), team_name);
        if (state) {
            for (int i = 0; i < contact.getTeamList().size(); i++) {
                if (contact.getTeamList().get(i) == team_name) {
                    contact.getTeamList().remove(i);
                }
            }
        }
        return state;
    }

    public boolean addLink(int idC, String team_name){
        Contact contact = this.contactList.get(idC);
        boolean state = this.contactDao.insertLink(contact.getIdC(), team_name);

        if (state) {
            // If the insert is ok, we get the id given by the database and add it to the java object before inserted it in the arrayList
            contact.getTeamList().add(team_name);
        }
        return state;    }

    public void getAllContacts() throws SQLException {
        ResultSet result = this.contactDao.selectAll();
        Contact contact;
        if (result.first()) {
            contact = new Contact(result.getString("contact_name"), result.getString("contact_first_name"), result.getString("contact_adress"), result.getString("contact_mail"), result.getString("contact_phone"));
            contact.setIdC(result.getInt("contact_id"));
            this.contactList.add(contact);
            while(result.next()){
                contact = new Contact(result.getString("contact_name"), result.getString("contact_first_name"), result.getString("contact_adress"), result.getString("contact_mail"), result.getString("contact_phone"));
                contact.setIdC(result.getInt("contact_id"));
                this.contactList.add(contact);
            }
        }
        //return result.isAfterLast();
    }

    /**
     * @return
     */
    public ArrayList<LightContact> getAllContact() {
        ResultSet result = this.contactDao.selectAll();
        return null;
    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

}