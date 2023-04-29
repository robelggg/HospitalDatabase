

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package hospitaldatabase3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Admin {
    public static void main(String[] args) {
        AdminGUI.main(args);
        HospitalConnection hospitalConnection = new HospitalConnection();
        Connection connection = hospitalConnection.getConnection();

        try {
            // Query for Patient table
            String patientQuery = "SELECT * FROM patient";
            Statement patientStatement = connection.createStatement();
            ResultSet patientResultSet = patientStatement.executeQuery(patientQuery);

            while (patientResultSet.next()) {
                // Process the patientResultSet data
                // Replace the column names with the actual names in your table
                System.out.println("Patient Info: ");
                System.out.println("Insurance Company: " + patientResultSet.getString("Insurance_Company"));
                System.out.println("Insurance ID: " + patientResultSet.getString("Insurance_Id"));
                System.out.println("First Name: " + patientResultSet.getString("First_Name"));
                System.out.println("Last Name: " + patientResultSet.getString("Last_Name"));
                System.out.println("Phone Number: " + patientResultSet.getString("Phone_num"));
                System.out.println("Address: " + patientResultSet.getString("Address"));
                System.out.println("---------");
            }
            patientResultSet.close();
            patientStatement.close();

            // Query for Doctor table
            String doctorQuery = "SELECT * FROM doctor";
            Statement doctorStatement = connection.createStatement();
            ResultSet doctorResultSet = doctorStatement.executeQuery(doctorQuery);

            while (doctorResultSet.next()) {
                // Process the doctorResultSet data
                // Replace the column names with the actual names in your table
                System.out.println("Doctor Info: ");
                System.out.println("Doctor ID: " + doctorResultSet.getString("Doc_Id"));
                System.out.println("First Name: " + doctorResultSet.getString("First_Name"));
                System.out.println("Last Name: " + doctorResultSet.getString("Last_Name"));
                System.out.println("Specialization: " + doctorResultSet.getString("Specialization"));
                System.out.println("---------");
            }
            doctorResultSet.close();
            doctorStatement.close();

            // Query for Appointment table
            String appointmentQuery = "SELECT * FROM appointment";
            Statement appointmentStatement = connection.createStatement();
            ResultSet appointmentResultSet = appointmentStatement.executeQuery(appointmentQuery);

            while (appointmentResultSet.next()) {
                // Process the appointmentResultSet data
                // Replace the column names with the actual names in your table
                System.out.println("Appointment Info: ");
                System.out.println("Appointment ID: " + appointmentResultSet.getString("Appointment_Num"));
                System.out.println("Insurance ID: " + appointmentResultSet.getString("Insurance_Id"));
                System.out.println("Doctor ID: " + appointmentResultSet.getString("Doc_Id"));
                System.out.println("Date and Time: " + appointmentResultSet.getString("Date_Time"));
                System.out.println("---------");
            }
            appointmentResultSet.close();
            appointmentStatement.close();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
