package hospitaldatabase3;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminGUI {
    //initalize
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new AdminGUI().createAndShowGUI();
        });
    }

    // method grabs sql from each table and prints on GUI table
    // method adds GUI dimensions
    private void createAndShowGUI() {
        JFrame frame = new JFrame("Administration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Patient table
        JTable patientTable = createTable("SELECT * FROM patient", new String[]{ "Insurance ID", "Insurance Company", "Last Name", "First Name", "Phone", "Address"});
        JScrollPane patientScrollPane = new JScrollPane(patientTable);
        tabbedPane.addTab("Patients", patientScrollPane);

        // Doctor table
        JTable doctorTable = createTable("SELECT * FROM doctor", new String[]{"Doctor ID",  "Last Name","First Name", "Specialization"});
        JScrollPane doctorScrollPane = new JScrollPane(doctorTable);
        tabbedPane.addTab("Doctors", doctorScrollPane);

        // Appointment table
        JTable appointmentTable = createTable("SELECT * FROM appointment", new String[]{"Appointment ID", "Insurance ID", "Doctor ID", "Date and Time"});
        JScrollPane appointmentScrollPane = new JScrollPane(appointmentTable);
        tabbedPane.addTab("Appointments", appointmentScrollPane);

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
   //adds data into a table on the GUI
    private JTable createTable(String query, String[] columnNames) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        JTable table = new JTable(model);

        try {
            HospitalConnection hospitalConnection = new HospitalConnection();
            Connection connection = hospitalConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Object[] rowData = new Object[columnNames.length];
                for (int i = 0; i < rowData.length; i++) {
                    rowData[i] = resultSet.getObject(i + 1);
                }
                model.addRow(rowData);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return table;
    }
}
