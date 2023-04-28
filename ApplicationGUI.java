/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitaldatabaseapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationGUI extends HospitalConnection{
    private JFrame mainFrame;
    private JButton patientButton;
    private JButton doctorButton;
    private JButton adminButton;

    public ApplicationGUI() {
        mainFrame = new JFrame("Hospital Database Application");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        patientButton = new JButton("Patient");
        doctorButton = new JButton("Doctor");
        adminButton = new JButton("Admin");

        panel.add(patientButton);
        panel.add(doctorButton);
        panel.add(adminButton);

        mainFrame.add(panel);
        mainFrame.setVisible(true);

        patientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                openPatientLogin();
            }
        });

        doctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                openDoctorLogin();
            }
        });
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                openAdminLogin();
    }
});
    }

    private void openPatientLogin() {
        JFrame patientLoginFrame = new JFrame("Patient Login");
        patientLoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        patientLoginFrame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel idLabel = new JLabel("Patient ID: ");
        JTextField idTextField = new JTextField();
        JLabel passwordLabel = new JLabel("Password: ");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        panel.add(idLabel);
        panel.add(idTextField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        patientLoginFrame.add(panel);
        patientLoginFrame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idTextField.getText();
                String password = new String(passwordField.getPassword());

               //We should work on connecting the database in this section 
               //To authenticate the id password

                patientLoginFrame.dispose();
                openPatientAppointments(id);
            }
        });
    }

    private void openPatientAppointments(String patientId) {
        JFrame appointmentsFrame = new JFrame("Patient Appointments");
        appointmentsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appointmentsFrame.setSize(400, 300);

        //Database connection here as well

        appointmentsFrame.setVisible(true);
    }

    private void openDoctorLogin() {
        JFrame doctorLoginFrame = new JFrame("Doctor Login");
        doctorLoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        doctorLoginFrame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel idLabel = new JLabel("Doctor ID: ");
        JTextField idTextField = new JTextField();
        JLabel passwordLabel = new JLabel("Password: ");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        panel.add(idLabel);
        panel.add(idTextField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        doctorLoginFrame.add(panel);
        doctorLoginFrame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idTextField.getText();
                String password = new String(passwordField.getPassword());

                 //We should work on connecting the database in this section 
               //To authenticate the id password

                doctorLoginFrame.dispose();
                openDoctorMenu(id);
            }
        });
    }

    private void openDoctorMenu(String doctorId) {
        JFrame doctorMenuFrame = new JFrame("Doctor Menu");
        doctorMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        doctorMenuFrame.setSize(400, 300);

       //Database Connection

        doctorMenuFrame.setVisible(true);
    }
    

private void openAdminLogin() {
    JFrame adminLoginFrame = new JFrame("Admin Login");
    adminLoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    adminLoginFrame.setSize(300, 200);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 2));

    JLabel idLabel = new JLabel("Admin ID: ");
    JTextField idTextField = new JTextField();
    JLabel passwordLabel = new JLabel("Password: ");
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login");

    panel.add(idLabel);
    panel.add(idTextField);
    panel.add(passwordLabel);
    panel.add(passwordField);
    panel.add(loginButton);

    adminLoginFrame.add(panel);
    adminLoginFrame.setVisible(true);

    loginButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = idTextField.getText();
            String password = new String(passwordField.getPassword());

             //We should work on connecting the database in this section 
               //To authenticate the id password
               
            adminLoginFrame.dispose();
            openAdminMenu();
        }
    });
}

private void openAdminMenu() {
    JFrame adminMenuFrame = new JFrame("Admin Menu");
    adminMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    adminMenuFrame.setSize(600, 400);

//Database

    adminMenuFrame.setVisible(true);
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ApplicationGUI();
            }
        });
    }
}


