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
        try {
            connect.setAutoCommit(false);
            String sql = "INSERT INTO anualbudget (anualbudget_listname,anualbudget_amount,anualbudget_year) "
                    + "VALUES (?, ?, ?)";
            PreparedStatement state = connect.prepareStatement(sql);
            state.setString(1, anual.getListname());
            state.setInt(2, anual.getAmount());
            state.setInt(3, anual.getYear());
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

    @Override
    public ResultSet getAll() {
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            ResultSet set =  state.executeQuery("SELECT * FROM anualbudget A ");
            return set;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ResultSet getAnualBudgetFromYear(int year){
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            ResultSet set =  state.executeQuery("SELECT * FROM anualbudget A where A.anualbudget_year =" + year +"::VARCHAR ");
            return set;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}