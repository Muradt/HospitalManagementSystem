package ehospital.dao.impl;

import ehospital.dao.DbHelper;
import ehospital.dao.PatientDao;
import ehospital.model.Patient;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PatientDaoImpl implements PatientDao {

    @Override
    public List<Patient> getPatientList() throws Exception {
        List<Patient> patientList = new ArrayList<>();
        String sql = "SELECT  ROWNUM R,ID,NAME,SURNAME,DOB,ADDRESS,PHONE,LOGIN,PASSWORD FROM PATIENT\n"
                + "WHERE ACTIVE = 1";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setR(rs.getLong("R"));
                patient.setId(rs.getLong("ID"));
                patient.setName(rs.getString("NAME"));
                patient.setSurName(rs.getString("SURNAME"));
                patient.setDob(rs.getDate("DOB"));
                patient.setAddress(rs.getString("ADDRESS"));
                patient.setPhone(rs.getString("PHONE"));
                patient.setLogin(rs.getString("LOGIN"));
                patient.setPassword(rs.getString("PASSWORD"));
                patientList.add(patient);

            }

        }
        return patientList;
    }
    
    @Override
    public List<Patient> getLoginedPatientList() throws Exception {
               List<Patient> patientList = new ArrayList<>();
        String sql = "SELECT  LOGIN,PASSWORD FROM PATIENT WHERE LOGIN IS NOT NULL AND PASSWORD IS NOT NULL\n"
                + "AND ACTIVE = 1";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setLogin(rs.getString("LOGIN"));
                patient.setPassword(rs.getString("PASSWORD"));
                patientList.add(patient);

            }

        }
        return patientList;
     }

    @Override
    public void addPatient(Patient patient) throws Exception {
        String sql = "insert into PATIENT(id,name,SURNAME,DOB,gender_id,address,phone)\n"
                + "values(PATIENT_SEQ.nextval,?,?,?,?,?,?)";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getSurName());
            ps.setDate(3, new java.sql.Date(patient.getDob().getTime()));
            ps.setInt(4, patient.getGenderID());
            ps.setString(5, patient.getAddress());
            ps.setString(6, patient.getPhone());
            ps.execute();
            c.commit();
        }
        System.out.println("Successfully added !!");
    }

    @Override
    public Patient getPatientbyId(Long patientId) throws Exception {
        String sql = "SELECT  ROWNUM R,ID,NAME,SURNAME,DOB,ADDRESS,PHONE FROM PATIENT\n"
                + "WHERE ID = ?";
        Patient patient = null;
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setLong(1, patientId);
            ResultSet rs = ps.executeQuery();
            patient = new Patient();
            if (rs.next()) {
                patient.setR(rs.getLong("R"));
                patient.setId(rs.getLong("ID"));
                patient.setName(rs.getString("NAME"));
                patient.setSurName(rs.getString("SURNAME"));
                patient.setDob(rs.getDate("DOB"));
                patient.setAddress(rs.getString("ADDRESS"));
                patient.setPhone(rs.getString("PHONE"));
            }
        }
        return patient;
    }

    @Override
    public void updatePatient(Patient patient) {
        String sql = "UPDATE PATIENT SET NAME=? ,SURNAME = ? , "
                + "DOB = ? ,ADDRESS =?,PHONE =? WHERE ID = ? ";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getSurName());
            ps.setDate(3, new java.sql.Date(patient.getDob().getTime()));
            ps.setString(4, patient.getAddress());
            ps.setString(5, patient.getPhone());
            ps.setLong(6, patient.getId());
            ps.execute();
            c.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deletePatient(Long patientId) throws Exception {
        String sql = "UPDATE PATIENT SET ACTIVE = 2 WHERE ID = ?";
        try (Connection c = DbHelper.getConnection();) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setLong(1, patientId);
            ps.execute();
            c.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Patient> searchPatientData(String keyword) throws Exception {
        List<Patient> patientList = new ArrayList<>();
        String sql = "SELECT  ROWNUM R,ID,NAME,SURNAME,DOB,ADDRESS,PHONE FROM PATIENT\n"
                + "WHERE ACTIVE = 1 AND (LOWER(NAME) LIKE LOWER(?) "
                + "OR LOWER(SURNAME) LIKE LOWER(?) "
                + "OR LOWER(ADDRESS) LIKE LOWER(?))";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setR(rs.getLong("R"));
                patient.setId(rs.getLong("ID"));
                patient.setName(rs.getString("NAME"));
                patient.setSurName(rs.getString("SURNAME"));
                patient.setDob(rs.getDate("DOB"));
                patient.setAddress(rs.getString("ADDRESS"));
                patient.setPhone(rs.getString("PHONE"));
                patientList.add(patient);

            }

        }
        return patientList;
    }

     
}
