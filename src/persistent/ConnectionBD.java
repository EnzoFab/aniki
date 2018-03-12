package persistent;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class ConnectionBD {

        public static void main(String[] args) {
            try {
                Class.forName("org.postgresql.Driver");
                System.out.println("Driver O.K.");

                String url = "jdbc:postgresql://localhost:5432/anikiDB";
                String user = "postgres";
                String passwd = "projetpromo";

                Connection conn = DriverManager.getConnection(url, user, passwd);
                System.out.println("Connexion effective !");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
