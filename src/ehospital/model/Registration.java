package ehospital.model;

import java.util.Date;

public class Registration {

    private long id;
    private Patient patient;
    private Doctor doctor;
    private Disease disease;
    private Room room;
    private Date date;
    private int Status;
    private long r;

    public long getR() {
        return r;
    }

    public void setR(long r) {
        this.r = r;
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public static void showRegistrations(Registration registration) {
        System.out.println(registration.getR() + "--" + registration.getPatient().getName() + "--" + registration.getPatient().getSurName() + "--" + registration.getDoctor().getName() + "--" + registration.getPatient().getSurName() + "--" + registration.getDisease().getName() + "--" + registration.getRoom().getRoomNumber() + "--" + registration.getStatus() + "--" + registration.getDate());
    }

    @Override
    public String toString() {
        return r + " " + patient.getName() + " " + patient.getSurName();
    }

}
