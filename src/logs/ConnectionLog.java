package logs;

public class ConnectionLog {
    private final static String url ="jdbc:postgresql://localhost:5432/anikidb";
    private final static String user= "postgres";
    private final static String pwd ="";


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
