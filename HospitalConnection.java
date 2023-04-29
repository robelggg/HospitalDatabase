/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package hospitaldatabase3;

import java.sql.*;

public class HospitalConnection {
    
    // Database connection settings
    private final String DB_URL = "jdbc:mysql://localhost:3306/hospital";
    private final String DB_DRV = "com.mysql.jdbc.Driver";
    private final String DB_USER = "root";
    private final String DB_PASSWD = "";
    
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public HospitalConnection() {
    }

    public int InsertStatement(String table, String newValue) {
        int rowsEffected = 0;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            rowsEffected = statement.executeUpdate("INSERT INTO " + table + " VALUES (" + newValue + ")");

        } catch (SQLException ex) {
            System.out.println("Error:" + ex);
        }

        return rowsEffected;
    }

    public int UpdateStatement(String table, String column, String newValue, String condition) {
        int rowsEffected = 0;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            rowsEffected = statement.executeUpdate("UPDATE " + table + " SET " + column + " = " + newValue + " WHERE " + condition);

        } catch (SQLException ex) {
            System.out.println("Error:" + ex);
        }

        return rowsEffected;
    }

    public int DeleteStatement(String table, String condition) {
        int rowsEffected = 0;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            rowsEffected = statement.executeUpdate("DELETE FROM " + table + " WHERE " + condition);

        } catch (SQLException ex) {
            System.out.println("Error:" + ex);
        }

        return rowsEffected;
    }

    public ResultSet SelectStatement(String column, String table) {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT " + column + " FROM " + table);

        } catch (SQLException ex) {
            System.out.println("Error:" + ex);
        }
        return resultSet;
    }

    public ResultSet SelectStatement(String column, String table, String condition) {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT " + column + " FROM " + table + " WHERE " + condition);

        } catch (SQLException ex) {
            System.out.println("Error:" + ex);
        }
        return resultSet;
    }

    public void EndConnection() {
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Error:" + ex);
        }
    }
}

