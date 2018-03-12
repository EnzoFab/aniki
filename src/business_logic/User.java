package business_logic;

public class User {
    private String mail;
    private String firstName;
    private String name;
    private String password;
    private String phone;

    private Team team;
    private Role role;

    public User(String mail, String firstName, String name, String password,String phone) {
        this.mail = mail;
        this.firstName = firstName;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    //Methods
    public String getMail() {
        return mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getName() {
        return name;
    }

    public String getPassword(){
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public Team getTeam() {
        return team;
    }

    public Role getRole() {
        return role;
    }

}
