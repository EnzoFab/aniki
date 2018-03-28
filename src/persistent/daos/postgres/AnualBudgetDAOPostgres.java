package persistent.daos.postgres;

import business_logic.AnualBudget;
import persistent.daos.AnualBudgetDAO;

import java.sql.*;

/**
 * 
 */
public class AnualBudgetDAOPostgres extends AnualBudgetDAO {


    public AnualBudgetDAOPostgres(Connection connection) {
        super(connection);
    }

    @Override
    public boolean deleteByID(int id) {
        return false;
    }

    @Override
    public boolean insert(int amount, int year, String listName) {
        Connection connect = getConnection();
        System.out.println("heoooo");
        try {
            connect.setAutoCommit(false);
            Statement state = connect.createStatement();
            String sql = "insert into anualbudget(anualbudget_listname, anualbudget_amount, anualbudget_year)"
                    +"values ("+listName+", "+amount+", "+year+");";
            state.executeUpdate(sql);
            state.close();
            connect.commit();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("hello");
            return false;
        }
        return true;
    }

    @Override
    public boolean insert(AnualBudget anual) {

        Connection connect = getConnection();
        System.out.println("heoooo");
        try {
            connect.setAutoCommit(false);
            String sql = "INSERT INTO anualbudget (anualbudget_listname,anualbudget_amount,anualbudget_year) "
                    + "VALUES (?, ?, ?)";
            PreparedStatement state = connect.prepareStatement(sql);
            state.setString(1, "hello");
            state.setInt(2, 23);
            state.setInt(3, 22);
            state.executeUpdate();
            connect.commit();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("hello");
            return false;
        }
        return true;
    }

    @Override
    public boolean update(String id, int amount){
        return false;
    }

    @Override
    public ResultSet getTransaction(){
        return null;
    }
}