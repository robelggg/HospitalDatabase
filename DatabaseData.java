
package hospitaldatabseapplication;


import static hospitaldatabseapplication.AdminGUI.createTable;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseData {

   
    public static void dataViewer( String tableName, String selectedItems, String conditionColumn, String columnValue) {
        String [] columns = null;
        String b = "`"; // backstick used for formatting
        String q = "'";  // single quotation for sql commands 
        switch (tableName) {
            case "patient" -> {
                columns = new String[]{ "Insurance ID", "Insurance Company", "Last Name", "First Name", "Phone", "Address"};
                tableName = "`patient`";
                conditionColumn = b + conditionColumn + b;       
                columnValue = q + columnValue + q;
            }
            case "doctor" -> {
                columns = new String[]{"Doctor ID",  "Last Name","First Name", "Specialization"};
                tableName = "`doctor`";
                conditionColumn = b + conditionColumn + b;
                columnValue = q + columnValue + q;
            }
            case "appointment" -> {
                columns = new String[]{"Appointment ID", "Insurance ID", "Doctor ID", "Date and Time"};
                tableName = "`appointment`";
                conditionColumn = b + conditionColumn + b;
                columnValue = q + columnValue + q;
            }
            default -> {
            }
        }
        
 //Java frame for table data viewer       
        JFrame frame = new JFrame("Administration");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Patient table
        JTable viewTable = createTable("SELECT" + selectedItems + " FROM " + tableName + " WHERE" + conditionColumn + "=" + columnValue 
                ,columns);
        JScrollPane dataScrollPane = new JScrollPane(viewTable);
        tabbedPane.addTab(tableName, dataScrollPane);

        
        frame.add(tabbedPane);
        frame.setVisible(true);
    }
    
    //================================end of data viever=====================================
    
     //overriding dataveiwer for only two arguments 
    /**
     * @param tableName
     * @param selectedItems
     * @override
     * 
     */
    public static void dataViewer(String tableName, String selectedItems){
         String [] columns = null;
        switch (tableName) {
            case "patient" -> {
                columns = new String[]{ "Insurance ID", "Insurance Company", "Last Name", "First Name", "Phone", "Address"};
                tableName = "`patient`";
            }
            case "doctor" -> {
                columns =  new String[]{"Doctor ID",  "Last Name","First Name", "Specialization"};
                tableName = "`doctor`";
            }
            case "appointment" -> {
                columns = new String[]{"Appointment ID", "Insurance ID", "Doctor ID", "Date and Time"};
                tableName = "`appointment`";
            }
            default -> {            }
        }
        JFrame frame = new JFrame("Administration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        JTabbedPane tabbedPane = new JTabbedPane();
       

        // Patient table
        JTable viewTable = createTable("SELECT" + selectedItems + " FROM " + tableName , columns);
        JScrollPane patientScrollPane = new JScrollPane(viewTable);
        tabbedPane.addTab("Patients", patientScrollPane);

        

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
    
    /**
     *
     * @param tableName
     * @param selectedItems
     * @param conditionColumn
     * @param columnValue
     * @return
     */
    public static JTable dataTable(String tableName, String selectedItems, String conditionColumn, String columnValue){
         String [] columns = null;
        switch (tableName) {
            case "patient" -> {
                columns = new String[]{ "Insurance ID", "Insurance Company", "Last Name", "First Name", "Phone", "Address"};
                tableName = "`patient`";
            }
            case "doctor" -> {
                columns =  new String[]{"Doctor ID",  "Last Name","First Name", "Specialization"};
                tableName = "`doctor`";
            }
            case "appointment" -> {
                columns = new String[]{"Appointment ID", "Insurance ID", "Doctor ID", "Date and Time"};
                tableName = "`appointment`";
            }
            default -> {            }}
            
            //Jtable for data rows
            JTable viewTable = createTable("SELECT" + selectedItems + " FROM " + tableName + " WHERE" + conditionColumn + "=" + columnValue 
                ,columns);
            
            return viewTable;
        
    }
    
    /**
 * Methods that creates a Jtable using the data from the database
 * @param query
 * @param columnNames
 * @return 
 */
    public static JTable createTable(String query, String[] columnNames) {
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