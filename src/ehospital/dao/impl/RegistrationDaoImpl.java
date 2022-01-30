package ehospital.dao.impl;

import ehospital.dao.DbHelper;
import ehospital.dao.RegistrationDao;
import ehospital.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDaoImpl implements RegistrationDao {

    @Override
    public List<Registration> getRegistationList() throws Exception {
        List<Registration> registrationList = new ArrayList<>();
        String sql = "select  ROWNUM RR,R.ID as REGISTRATION_ID ,P.NAME AS PATIENT_NAME ,P.SURNAME AS PATIENT_SURNAME, D.NAME AS DOCTOR_NAME,D.SURNAME AS DOCTOR_SURNAME,D2.NAME AS DISEASE_NAME,R2.ROOM_NUMBER AS ROOM_NUMBER,R.STATUS AS REGISTRATION_STATUS, R.REGISTER_DATE AS REGISTRATION_DATE from REGISTRATION R\n"
                + "inner join PATIENT P on R.PATIENT_ID = P.ID\n"
                + "inner join DOCTOR D on D.ID = R.DOCTOR_ID\n"
                + "inner join DISEASE D2 on D2.ID = R.DISEASE_ID\n"
                + "inner join ROOM R2 on R2.ID = R.ROOM_ID\n"
                + "WHERE R.STATUS IN(1,3)";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Registration registration = new Registration();
                registration.setR(rs.getLong("RR"));
                registration.setId(rs.getLong("REGISTRATION_ID"));
                registration.setStatus(rs.getInt("REGISTRATION_STATUS"));
                registration.setDate(rs.getDate("REGISTRATION_DATE"));
                Patient patient = new Patient();
                patient.setName(rs.getString("PATIENT_NAME"));
                patient.setSurName(rs.getString("PATIENT_SURNAME"));
                Doctor doctor = new Doctor();
                doctor.setName(rs.getString("DOCTOR_NAME"));
                doctor.setSurName(rs.getString("DOCTOR_SURNAME"));
                Disease disease = new Disease();
                disease.setName(rs.getString("DISEASE_NAME"));
                Room room = new Room();
                room.setRoomNumber(rs.getInt("ROOM_NUMBER"));

                registration.setPatient(patient);
                registration.setDoctor(doctor);
                registration.setDisease(disease);
                registration.setRoom(room);

                registrationList.add(registration);

            }

        }
        return registrationList;
    }

    @Override
    public void addRegistration(Registration registration) throws Exception {
        String sql = "insert into REGISTRATION (ID, PATIENT_ID, DOCTOR_ID, DISEASE_ID, ROOM_ID)\n"
                + "VALUES (REGISTER_SEQ.nextval,?,?,?,?)";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setLong(1, registration.getPatient().getId());
            ps.setLong(2, registration.getDoctor().getId());
            ps.setLong(3, registration.getDisease().getID());
            ps.setLong(4, registration.getRoom().getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public List<Registration> getUnpaidRegistationList() throws Exception {
        List<Registration> registrationList = new ArrayList<>();
        String sql = "select  R.ID as REGISTRATION_ID ,P.NAME AS PATIENT_NAME ,P.SURNAME AS PATIENT_SURNAME, D.NAME AS DOCTOR_NAME,D.SURNAME AS DOCTOR_SURNAME,D2.NAME AS DISEASE_NAME,R2.ROOM_NUMBER AS ROOM_NUMBER,R.STATUS AS REGISTRATION_STATUS, R.REGISTER_DATE AS REGISTRATION_DATE from REGISTRATION R\n"
                + " inner join PATIENT P on R.PATIENT_ID = P.ID\n"
                + " inner join DOCTOR D on D.ID = R.DOCTOR_ID\n"
                + " inner join DISEASE D2 on D2.ID = R.DISEASE_ID\n"
                + " inner join ROOM R2 on R2.ID = R.ROOM_ID\n"
                + " WHERE R.STATUS = 1";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Registration registration = new Registration();
                registration.setId(rs.getLong("REGISTRATION_ID"));
                registration.setStatus(rs.getInt("REGISTRATION_STATUS"));
                registration.setDate(rs.getDate("REGISTRATION_DATE"));
                Patient patient = new Patient();
                patient.setName(rs.getString("PATIENT_NAME"));
                patient.setSurName(rs.getString("PATIENT_SURNAME"));
                Doctor doctor = new Doctor();
                doctor.setName(rs.getString("DOCTOR_NAME"));
                doctor.setSurName(rs.getString("DOCTOR_SURNAME"));
                Disease disease = new Disease();
                disease.setName(rs.getString("DISEASE_NAME"));
                Room room = new Room();
                room.setRoomNumber(rs.getInt("ROOM_NUMBER"));

                registration.setPatient(patient);
                registration.setDoctor(doctor);
                registration.setDisease(disease);
                registration.setRoom(room);

                registrationList.add(registration);

            }

        }
        return registrationList;
    }

    @Override
    public void deleteRegistration(Long registrationId) {
        String sql = "UPDATE REGISTRATION SET STATUS = 2 WHERE ID = ?";
        try (Connection c = DbHelper.getConnection();) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setLong(1, registrationId);
            ps.execute();
            c.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void changeRegistrationStatus(Long registrationId, int registrationStatus) throws Exception {
        String sql = "UPDATE REGISTRATION SET STATUS = ? WHERE ID = ? ";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, registrationStatus);
            ps.setLong(2, registrationId);
            ps.execute();
            c.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Registration getRegistrationById(Long registrationId) throws Exception {
        String sql = "select R.ID as REGISTRATION_ID ,P.ID as PATIENT_ID,P.NAME AS PATIENT_NAME,P.SURNAME AS PATIENT_SURNAME, D.ID AS DOCTOR_ID, D2.ID AS DISEASE_ID,R2.ID AS ROOM_ID from REGISTRATION R\n"
                + "inner join PATIENT P on R.PATIENT_ID = P.ID\n"
                + "inner join DOCTOR D on D.ID = R.DOCTOR_ID\n"
                + "inner join DISEASE D2 on D2.ID = R.DISEASE_ID\n"
                + "inner join ROOM R2 on R2.ID = R.ROOM_ID\n"
                + "WHERE R.STATUS IN(1,3) AND R.ID = ?";
        Registration registration = null;
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setLong(1, registrationId);
            ResultSet rs = ps.executeQuery();
            registration = new Registration();
            if (rs.next()) {
                registration.setId(rs.getLong("REGISTRATION_ID"));
                Patient patient = new Patient();
                patient.setId(rs.getLong("PATIENT_ID"));
                patient.setName(rs.getString("PATIENT_NAME"));
                patient.setSurName(rs.getString("PATIENT_SURNAME"));
                Doctor doctor = new Doctor();
                doctor.setId(rs.getLong("DOCTOR_ID"));
                Disease disease = new Disease();
                disease.setID(rs.getLong("DISEASE_ID"));
                Room room = new Room();
                room.setId(rs.getLong("ROOM_ID"));
                registration.setPatient(patient);
                registration.setDoctor(doctor);
                registration.setDisease(disease);
                registration.setRoom(room);
            }
        }
        return registration;
    }

    @Override
    public void updateRegistration(Registration registration) throws Exception {
        String sql = "UPDATE REGISTRATION SET PATIENT_ID=?, DOCTOR_ID=? , DISEASE_ID =? , ROOM_ID = ? "
                + "WHERE ID = ? ";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setLong(1, registration.getPatient().getId());
            ps.setLong(2, registration.getDoctor().getId());
            ps.setLong(3, registration.getDisease().getID());
            ps.setLong(4, registration.getRoom().getId());
            ps.setLong(5, registration.getId());
            ps.execute();
            c.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Registration> searchRegistrationData(String keyword) throws Exception {

        List<Registration> registrationList = new ArrayList<>();
        String sql = "select  ROWNUM RR,R.ID as REGISTRATION_ID ,P.NAME AS PATIENT_NAME ,P.SURNAME AS PATIENT_SURNAME, D.NAME AS DOCTOR_NAME,D.SURNAME AS DOCTOR_SURNAME,D2.NAME AS DISEASE_NAME,R2.ROOM_NUMBER AS ROOM_NUMBER,R.STATUS AS REGISTRATION_STATUS, R.REGISTER_DATE AS REGISTRATION_DATE from REGISTRATION R\n"
                + "inner join PATIENT P on R.PATIENT_ID = P.ID\n"
                + "inner join DOCTOR D on D.ID = R.DOCTOR_ID\n"
                + "inner join DISEASE D2 on D2.ID = R.DISEASE_ID\n"
                + "inner join ROOM R2 on R2.ID = R.ROOM_ID\n"
                + "WHERE R.STATUS IN(1,3)";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Registration registration = new Registration();
                registration.setR(rs.getLong("RR"));
                registration.setId(rs.getLong("REGISTRATION_ID"));
                registration.setStatus(rs.getInt("REGISTRATION_STATUS"));
                registration.setDate(rs.getDate("REGISTRATION_DATE"));
                Patient patient = new Patient();
                patient.setName(rs.getString("PATIENT_NAME"));
                patient.setSurName(rs.getString("PATIENT_SURNAME"));
                Doctor doctor = new Doctor();
                doctor.setName(rs.getString("DOCTOR_NAME"));
                doctor.setSurName(rs.getString("DOCTOR_SURNAME"));
                Disease disease = new Disease();
                disease.setName(rs.getString("DISEASE_NAME"));
                Room room = new Room();
                room.setRoomNumber(rs.getInt("ROOM_NUMBER"));

                registration.setPatient(patient);
                registration.setDoctor(doctor);
                registration.setDisease(disease);
                registration.setRoom(room);

                registrationList.add(registration);

            }

        }
        return registrationList;
    }

}
