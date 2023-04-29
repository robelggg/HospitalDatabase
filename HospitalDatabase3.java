/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospitaldatabase3;

import java.util.*;;
import java.sql.*;
/**
 *
 * @author robelg
 */
public class HospitalDatabase3 {

   public static void main(String[] args) {

        // creates Connection object
          Connection conn1 = null;
       

        try {
            // connect way #1
            String url1 = "jdbc:mysql://localhost:3306/HospitalDatabase";
            String user = "root";
            String password = "";

            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database ecommerce");
                
                Statement stmt = conn1.createStatement();   //Creating Statement.
                //Executing Statement.
               // stmt.executeUpdate("create table `ScoreHistory`(`id` integer, `Player1` varchar(20), `Player2` varchar(20), `Score` integer)");
                //stmt.executeUpdate("insert into `appointment` values( 124, 'SJFBFB', 133, '2023-01-09 12:15:00')");
               
                
            }
            
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();

        }
        finally {
            if (conn1 != null) {
                try {
                    conn1.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
}
        
    }


    
}
