/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitaldatabaseapplication;

import java.sql.*;

/**
 *
 * @author Elvis
 */
public class HospitalConnection {
    
    private final String DB_URL = "jdbc:mysql://localhost:3306/Psychiatric";
    private final String DB_DRV = "com.mysql.jdbc.Driver";
    private final String DB_USER = "root";
    private final String DB_PASSWD = "";
    
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
 
    //Constructor that creates an instance of this class which represents
    //a session of accessing the database
    public HospitalConnection(){
        
    }
    
    //Method that will take two Strings, one will be called table which holds
    //what table will be inserted into, and a second string for newValue which contains
    //the values that will be inserted
    //Important fact: newValues can also contain multiple new values,
    //for example, newValue = "\'John\',\'Smith\',\'103th ave\'"
    public int InsertStatement(String table, String newValue){
        
        int rowsEffected = 0;
        
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            rowsEffected = statement.executeUpdate("INSERT INTO " + table + "VALUES (" + newValue + ")");
            
        } catch (SQLException ex) {
            System.out.println("Error:" + ex);
        }
        
        return rowsEffected;
        
    }
    
    //This method is meant to update a table in the database, its signature includes a string called table which
    //contains what table will be effect, a string for which column will be effected, a string for the newValue
    //being put in that column, and finally a string for what condition will cause the update
    public int UpdateStatement(String table, String column, String newValue, String condition){
        
        int rowsEffected = 0;
        
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            rowsEffected = statement.executeUpdate("UPDATE " + table + " SET "+ column + " = " + newValue + " WHERE " + condition);
            
        } catch (SQLException ex) {
            System.out.println("Error:" + ex);
        }
        
        return rowsEffected;
        
    }
    
    //This method takes in two Strings, one that represents the table from which the user
    //wants to delete from, and a second String representing what condition is applied to that
    //delete statement. for ex: table = patient, condition = patient_id = Z408HJ
    //This method returns the number of rows effected by the delete statement
    public int DeleteStatement(String table, String condition){
        
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
    
    //Method that will take what column the user wants to select and what table
    //that column will be from. Then the method will return a result set containing
    //everything picked up by the select statement
    public ResultSet SelectStatement(String column, String table){
        
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT " + column + " FROM " + table);
            
        } catch (SQLException ex) {
            System.out.println("Error:" + ex);
        }
        return resultSet;
    }
    
    //This is an overloaded version of the Select Statement method that takes the extra string
    //named "condition" that represents any condition the user wants to put on the select statment
    //This can be better seen in the line of resultSet =, where the words ' "WHERE " + condition ' are added
    public ResultSet SelectStatement(String column, String table, String condition){
        
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT " + column + " FROM " + table + " WHERE " + condition);
            
        } catch (SQLException ex) {
            System.out.println("Error:" + ex);
        }
        return resultSet;
    }
    
    //This Method will be called at the end of a session and it will close
    //the result set, statement, and connection
    public void EndConnection(){
        try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Error:" + ex);
            }
    }
    
}
