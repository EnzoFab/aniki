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
        String year = String.valueOf(id);
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            int numberRowModified =  state.executeUpdate("DELETE FROM anualbudget WHERE anualbudget_year = '"+year+"'");
            return numberRowModified == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insert(int amount, int year, String listName) {
        Connection connect = getConnection();
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
            String sql = "INSERT INTO anualbudget (anualbudget_listname,anualbudget_amount,anualbudget_year) "
                    + "VALUES (?, ?, ?)";
            PreparedStatement state = connect.prepareStatement(sql);
            state.setString(1, anual.getListname());
            state.setInt(2, anual.getAmount());
            state.setInt(3, anual.getYear());
            state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(String id, int amount, String year){
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            int numberRowModified =  state.executeUpdate("UPDATE anualbudget SET anualbudget_listname = '"+ id +"', anualbudget_amount = '"+amount +"' WHERE anualbudget_year = '"+ year +"' ");
            return numberRowModified == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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