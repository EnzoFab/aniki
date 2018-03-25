package persistent.daos;

import java.sql.Connection;

public abstract class DAO {
    private final Connection connection;

    public DAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }
}
