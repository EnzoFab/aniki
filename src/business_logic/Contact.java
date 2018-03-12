package business_logic;

public class Contact {

    private String name;
    private String place;
    private String phoneNumber;

    public Contact (String name, String place, String phoneNumber){
        this.name = name;
        this.place = place;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
