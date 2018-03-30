package persistent.daos.postgres;

import persistent.daos.PaymentMethodDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 */
public class PaymentMethodDAOPostgres extends PaymentMethodDAO {


    public PaymentMethodDAOPostgres(Connection connection) {
        super(connection);
    }

    @Override
    public ResultSet getAll() {
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            ResultSet set =  state.executeQuery("SELECT * FROM paymentmethod");
            return set;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}