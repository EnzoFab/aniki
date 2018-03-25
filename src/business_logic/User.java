package business_logic;

import java.util.*;

/**
 * 
 */
public class User implements LightUser {


    /**
     * 
     */
    private String mail;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String firstName;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String phone;


    public User(String mail, String name, String firstName, String password, String phone) {
        this.mail = mail;
        this.name = name;
        this.firstName = firstName;
        this.password = password;
        this.phone = phone;
    }

    @Override
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}