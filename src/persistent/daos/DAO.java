package persistent.daos;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @see ResultSet
 */
public abstract class DAO {
    private final Connection connection;

    /**
     * @param connection
     */
    public DAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Get the connection associated to the dao
     * @return
     */
    public Connection getConnection() {
        return connection;
    }
}
