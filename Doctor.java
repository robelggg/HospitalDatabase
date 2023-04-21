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
    public Doctor(int doctorId, String doctorLastName, String doctorFirstName, String Specialization){
        
        this.doctorId = doctorId;
        this.doctorLastName = doctorLastName;
        this.doctorFirstName = doctorFirstName;
        this.Specialization = Specialization;
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
