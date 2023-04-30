/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package hospitaldatabase3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HospitalConnection {
    private Connection connection;

    public HospitalConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/HospitalDatabase";
            String user = "root";
            String password = "";

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
            if (this.connection != null) {
                System.out.println("Connected to the database HospitalDatabase");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }
}
