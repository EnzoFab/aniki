package logs;

public class ConnectionLog {
    private final static String url ="jdbc:postgresql://localhost:5432/anikidb"; // your db name
    private final static String user= "postgres"; // user name to conect to your db
    private final static String pwd =""; // password to connect to your database


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
