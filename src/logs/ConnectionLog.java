package logs;

public class ConnectionLog {
    private final static String url ="jdbc:postgresql://localhost:5432/anikiDB";
    private final static String user= "postgres";
    private final static String pwd ="postgres";
    private final static String userNameGoogle = "yourbestfriend.aniki@gmail.com";
    private final static String passwordGoogle = "";

    public static String getUserNameGoogle() {
        return userNameGoogle;
    }

    public static String getPasswordGoogle() {
        return passwordGoogle;
    }

    public static String getUrl(){
        return url;
    }

    public static String getUser(){
        return user;
    }

    public static String getPwd(){
        return pwd;
    }

}
