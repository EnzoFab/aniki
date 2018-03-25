package persistent.daos;

import java.sql.Connection;
import java.sql.ResultSet;

public abstract class PaymentMethodDAO  extends DAO{
    public PaymentMethodDAO(Connection connection) {
        super(connection);
    }

    public abstract ResultSet getAll();
}
