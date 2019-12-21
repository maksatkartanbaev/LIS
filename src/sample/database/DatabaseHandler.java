package sample.database;

import javax.swing.*;
import java.sql.*;

public class DatabaseHandler {
    private static DatabaseHandler handler;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "striker";
    private static final String PASSWORD = "eredivise";
    private static String username = "java";
    private static Connection conn = null;
    private static Statement stmt = null;

    public DatabaseHandler(){
        createConnection();
    }

    void createConnection(){
        System.out.println("Connecting...");
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected");
        } catch (Exception e){
            System.out.println(e.getMessage() + "-------BOOOOM------");
        }
    }

    public ResultSet execQuery(String query){
        ResultSet result;
        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
        } catch (SQLException ex){
            System.out.println("execQuery from DatabaseHandler got a problem, boss: " + ex.getLocalizedMessage());
            return null;
        }
        return result;
    }

    public boolean execAction(String query){
        try {
            stmt = conn.createStatement();
            stmt.execute(query);
            return true;
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "We got a problem!", JOptionPane.ERROR_MESSAGE);
            System.out.println("execAction from DatabaseHandler got a problem, boss: " + ex.getLocalizedMessage());
            return false;
        }
    }
}
