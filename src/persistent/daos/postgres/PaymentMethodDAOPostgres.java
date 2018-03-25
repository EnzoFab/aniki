package persistent.daos.postgres;

import persistent.daos.PaymentMethodDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

/**
 * 
 */
public class PaymentMethodDAOPostgres extends PaymentMethodDAO {


    public PaymentMethodDAOPostgres(Connection connection) {
        super(connection);
    }

    @Override
    public ResultSet getAll() {
        return null;
    }
}