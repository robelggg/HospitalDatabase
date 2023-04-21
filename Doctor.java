/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitaldatabaseapplication;

/**
 *
 * @author Elvis
 */
public class Doctor {
    
    //private int variable that holds doctor's ID
    private int doctorId;
    
    //private String variable that holds doctor's Last Name
    private String doctorLastName;
    
    //private String variable that holds doctor's First Name
    private String doctorFirstName;
    
    //private String variable that holds a doctor's Specialization
    private String Specialization;
    
    //Constructor that takes in 4 variables and assigns them to an instance of the Doctor class
    public Doctor(int doctorId){
        
        this.doctorId = doctorId;
        /**
         *  
         * For the rest of these private variables, I was thinking that 
         * we could use some kind of method related to the database connection class
         * where we could simply use the doctorId that the user inputs in order to find
         * out what the last name, first name and specialization is
         * 
         * for example, if someone inputs the doctor id 102 into the GUI, this constructor would use a method
         * to connect to the database and run a select statement like "SELECT Last_Name FROM Doctor WHERE Doc_ID = 102"
         * and the last name that returns would be assigned to this.doctorLastName
         * 
         * ex: this.doctorLastName = MethodName("SELECT Last_Name FROM Doctor WHERE Doc_ID = " + doctorId + ");
         * 
        this.doctorLastName ;
        this.doctorFirstName ;
        this.Specialization ;
        */ 
    }
    
    //Getter that returns a doctor's Id
    public int getDoctorId(){
        return this.doctorId;
    }
    
    //Getter that returns a doctor's Last Name
    public String getDoctorLastName(){
        return this.doctorLastName;
    }
    
    //Getter that returns a doctor's First Name
    public String getDoctorFirstName(){
        return this.doctorFirstName;
    }
    
    //Getter that returns a doctor's Specialization
    public String getDoctorSpecialization(){
        return this.Specialization;
    }
    
    //Method that returns all the rows in the appointment table of the MySQL database that
    //contains the Doctor's Id
    public String getAppointment(){
        
        return "Result Set goes here";
    }
}
