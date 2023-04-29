package hospitaldatabase3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// AdminData.java
public class AdminData {
    private String phoneNum;
    private String address;
    private String patientFirstName;
    private String patientLastName;
    private String insuranceCompany;
    private String patientAppointmentInfo;
    private String doctorAppointmentInfo;

    public AdminData(String phoneNum, String address, String patientFirstName, String patientLastName, String insuranceCompany, String patientAppointmentInfo, String doctorAppointmentInfo) {
        this.phoneNum = phoneNum;
        this.address = address;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.insuranceCompany = insuranceCompany;
        this.patientAppointmentInfo = patientAppointmentInfo;
        this.doctorAppointmentInfo = doctorAppointmentInfo;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public String getPatientAppointmentInfo() {
        return patientAppointmentInfo;
    }

    public String getDoctorAppointmentInfo() {
        return doctorAppointmentInfo;
    }
}