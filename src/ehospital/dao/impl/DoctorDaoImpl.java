package ehospital.dao.impl;

import ehospital.dao.DbHelper;
import ehospital.dao.DoctorDao;
import ehospital.model.Doctor;
import ehospital.model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao {

    @Override
    public List<Doctor> getDoctorList() throws Exception {
        List<Doctor> doctorList = new ArrayList<>();
        String sql = "select  ROWNUM R,ID,NAME,SURNAME,DOB,GENDER_ID,ADDRESS,EMAIL,SALARY,PHONE,WORK_EXPERIENCE,PORTION,LOGIN,PASSWORD from DOCTOR\n"
                + "where ACTIVE =1";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setR(rs.getLong("R"));
                doctor.setId(rs.getLong("ID"));
                doctor.setName(rs.getString("NAME"));
                doctor.setSurName(rs.getString("SURNAME"));
                doctor.setDob(rs.getDate("DOB"));

                doctor.setGenderID(rs.getInt("GENDER_ID"));
                doctor.setAddress(rs.getString("ADDRESS"));
                doctor.setEmail(rs.getString("EMAIL"));
                doctor.setSalary(rs.getFloat("SALARY"));
                doctor.setPhone(rs.getString("PHONE"));
                doctor.setWorkExperience(rs.getInt("WORK_EXPERIENCE"));
                doctor.setPortion(rs.getInt("PORTION"));
                doctor.setLogin(rs.getString("LOGIN"));
                doctor.setPassword(rs.getString("PASSWORD"));
                doctorList.add(doctor);

            }

        }
        return doctorList;
    }
     @Override
    public List<Doctor> getLoginedDoctorList() throws Exception {
                List<Doctor> doctorList = new ArrayList<>();
        String sql = "select  LOGIN,PASSWORD from DOCTOR\n"
                + "where ACTIVE =1 and LOGIN is not null and PASSWORD is not null";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setLogin(rs.getString("LOGIN"));
                doctor.setPassword(rs.getString("PASSWORD"));
                doctorList.add(doctor);

            }

        }
        return doctorList;
    }

    @Override
    public void addDoctor(Doctor doctor) throws Exception {
        String sql = "insert into Doctor(id,name,SURNAME,dob,gender_id,address,email,phone,salary,WORK_EXPERIENCE,portion)\n"
                + "values(DOCTOR_SEQ.nextval,?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSurName());
            ps.setDate(3, new java.sql.Date(doctor.getDob().getTime()));
            ps.setInt(4, doctor.getGenderID());
            ps.setString(5, doctor.getAddress());
            ps.setString(6, doctor.getEmail());
            ps.setString(7, doctor.getPhone());
            ps.setFloat(8, doctor.getSalary());
            ps.setInt(9, doctor.getWorkExperience());
            ps.setInt(10, doctor.getPortion());
            ps.execute();
            c.commit();
        }
        System.out.println("Successfully added !!");
    }

    @Override
    public void deleteDoctor(Long doctorId) throws Exception {
        String sql = "UPDATE DOCTOR SET ACTIVE = 2 WHERE ID = ?";
        try (Connection c = DbHelper.getConnection();) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setLong(1, doctorId);
            ps.execute();
            c.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Doctor getDoctorbyId(Long doctorId) throws Exception {
        String sql = "SELECT  ROWNUM R,ID,NAME,SURNAME,dob,gender_id,address,email,phone,salary,WORK_EXPERIENCE,portion FROM DOCTOR\n"
                + "WHERE ID = ?";
        Doctor doctor = null;
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setLong(1, doctorId);
            ResultSet rs = ps.executeQuery();
            doctor = new Doctor();
            if (rs.next()) {
                doctor.setR(rs.getLong("R"));
                doctor.setId(rs.getLong("ID"));
                doctor.setName(rs.getString("NAME"));
                doctor.setSurName(rs.getString("SURNAME"));
                doctor.setDob(rs.getDate("DOB"));

                doctor.setGenderID(rs.getInt("gender_id"));
                doctor.setAddress(rs.getString("ADDRESS"));
                doctor.setEmail(rs.getString("email"));
                doctor.setPhone(rs.getString("PHONE"));
                doctor.setSalary(rs.getFloat("salary"));
                doctor.setWorkExperience(rs.getInt("WORK_EXPERIENCE"));
                doctor.setPortion(rs.getInt("portion"));
            }
        }
        return doctor;
    }

    @Override
    public void updateDoctor(Doctor d) throws Exception {
        String sql = "UPDATE DOCTOR SET NAME=? ,SURNAME = ? , "
                + "DOB = ?,gender_id = ?,ADDRESS =?, email = ?, salary = ? , PHONE =?, work_experience = ? , portion = ? WHERE ID = ? ";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, d.getName());
            ps.setString(2, d.getSurName());
            ps.setDate(3, new java.sql.Date(d.getDob().getTime()));
            ps.setInt(4, d.getGenderID());
            ps.setString(5, d.getAddress());
            ps.setString(6, d.getEmail());
            ps.setFloat(7, d.getSalary());
            ps.setString(8, d.getPhone());
            ps.setInt(9, d.getWorkExperience());
            ps.setInt(10, d.getPortion());
            ps.setLong(11, d.getId());
            ps.execute();
            c.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Doctor> searchDoctorData(String keyword) throws Exception {
        List<Doctor> doctorList = new ArrayList<>();
        String sql = "select  ROWNUM R,ID,NAME,SURNAME,DOB,GENDER_ID,ADDRESS,EMAIL,SALARY,PHONE,WORK_EXPERIENCE,PORTION from DOCTOR\n"
                + "where ACTIVE =1 AND (LOWER(NAME) LIKE LOWER(?) "
                + "OR LOWER(SURNAME) LIKE LOWER(?) "
                + "OR LOWER(ADDRESS) LIKE LOWER(?)"
                + "OR PHONE LIKE ? )";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
            ps.setString(4, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setR(rs.getLong("R"));
                doctor.setId(rs.getLong("ID"));
                doctor.setName(rs.getString("NAME"));
                doctor.setSurName(rs.getString("SURNAME"));
                doctor.setDob(rs.getDate("DOB"));
                doctor.setGenderID(rs.getInt("GENDER_ID"));
                doctor.setAddress(rs.getString("ADDRESS"));
                doctor.setEmail(rs.getString("EMAIL"));
                doctor.setSalary(rs.getFloat("SALARY"));
                doctor.setPhone(rs.getString("PHONE"));
                doctor.setWorkExperience(rs.getInt("WORK_EXPERIENCE"));
                doctor.setPortion(rs.getInt("PORTION"));
                doctorList.add(doctor);

            }

        }
        return doctorList;

    }

   
}
