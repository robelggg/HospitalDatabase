package hospitaldatabase3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {
    private JFrame frame;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;

    public Admin() {
        frame = new JFrame("Administration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);

        String[] columnNames = {"Phone", "Address", "First Name", "Last Name", "Insurance Company", "Patient Appointment", "Doctor Appointment"};

        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        frame.add(scrollPane);
        frame.setVisible(true);
    }

    public void addAdminToTable(AdminData admin) {
        Object[] rowData = {
                admin.getPhoneNum(),
                admin.getAddress(),
                admin.getPatientFirstName(),
                admin.getPatientLastName(),
                admin.getInsuranceCompany(),
                admin.getPatientAppointmentInfo(),
                admin.getDoctorAppointmentInfo()
        };

        tableModel.addRow(rowData);
    }

    public static void main(String[] args) {
        Admin adminTable = new Admin();

        // 1. Instantiate the HospitalConnection class
        HospitalConnection hospitalConnection = new HospitalConnection();

        // 2. Call the SelectStatement method to retrieve the data
        ResultSet resultSet = hospitalConnection.SelectStatement("*", "HospitalDatabase3");

        // 3. Loop through the ResultSet and add the data to the table
        try {
            while (resultSet.next()) {
                String phone = resultSet.getString("Phone");
                String address = resultSet.getString("Address");
                String firstName = resultSet.getString("First_Name");
                String lastName = resultSet.getString("Last_Name");
                String insuranceCompany = resultSet.getString("Insurance_Company");
                String patientAppointment = resultSet.getString("Patient_Appointment");
                String doctorAppointment = resultSet.getString("Doctor_Appointment");

                AdminData adminData = new AdminData(phone, address, firstName, lastName, insuranceCompany, patientAppointment, doctorAppointment);
                adminTable.addAdminToTable(adminData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            hospitalConnection.EndConnection();
        }
    }
}
