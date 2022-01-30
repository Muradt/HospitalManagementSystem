package ehospital.dao.impl;

import ehospital.dao.DbHelper;
import ehospital.dao.ReceiptDao;
import ehospital.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReceiptDaoImpl implements ReceiptDao {

    @Override
    public List<Receipt> getReceiptList() throws Exception {
        List<Receipt> receiptList = new ArrayList<>();
        String sql = "select ROWNUM RR, R1.ID as RECEIPT_ID,P.NAME AS PATIENT_NAME ,P.SURNAME AS PATIENT_SURNAME, D.NAME AS DOCTOR_NAME,D.SURNAME AS DOCTOR_SURNAME,D2.NAME AS DISEASE_NAME ,R1.MEDICINE as MEDICINE_NAME, R1.DATA_DATE AS RECEIPT_DATE from RECEIPT R1\n"
                + "inner join REGISTRATION R on R.ID = R1.REGISTRATION_ID\n"
                + "inner join PATIENT P on P.ID = R.PATIENT_ID\n"
                + "inner join DOCTOR D on D.ID = R.DOCTOR_ID\n"
                + "inner join DISEASE D2 on D2.ID = R.DISEASE_ID where R1.STATUS = 1";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Receipt receipt = new Receipt();
                receipt.setId(rs.getLong("RECEIPT_ID"));
                receipt.setR(rs.getLong("RR"));
                receipt.setMedicineName(rs.getString("MEDICINE_NAME"));
                receipt.setData_date(rs.getDate("RECEIPT_DATE"));
                Registration registration = new Registration();
                Patient patient = new Patient();
                patient.setName(rs.getString("PATIENT_NAME"));
                patient.setSurName(rs.getString("PATIENT_SURNAME"));
                Doctor doctor = new Doctor();
                doctor.setName(rs.getString("DOCTOR_NAME"));
                doctor.setSurName(rs.getString("DOCTOR_SURNAME"));
                Disease disease = new Disease();
                disease.setName(rs.getString("DISEASE_NAME"));

                registration.setPatient(patient);
                registration.setDoctor(doctor);
                registration.setDisease(disease);
                receipt.setRegistration(registration);

                receiptList.add(receipt);
            }
        }
        return receiptList;
    }

    @Override
    public void addReceipt(Receipt receipt) throws Exception {
        String sql = "insert into Receipt (ID,REGISTRATION_ID,MEDICINE)\n"
                + "VALUES (RECEIPT_SEQ.nextval,?,?)";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setLong(1, receipt.getRegistration().getId());
            ps.setString(2, receipt.getMedicineName());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void deleteReceipt(Long receiptId) throws Exception {
        String sql = "UPDATE Receipt SET STATUS = 2 WHERE ID = ?";
        try (Connection c = DbHelper.getConnection();) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setLong(1, receiptId);
            ps.execute();
            c.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Receipt getReceiptById(Long receiptId) throws Exception {
        String sql = "SELECT  R1.ID AS RECEIPT_ID,R1.REGISTRATION_ID AS REGISTER_ID,R1.MEDICINE AS MEDICINE FROM RECEIPT R1\n"
                + "inner join REGISTRATION R on R.ID = R1.REGISTRATION_ID\n"
                + "WHERE R1.ID = ?";
        Receipt receipt = null;
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setLong(1, receiptId);
            ResultSet rs = ps.executeQuery();
            receipt = new Receipt();
            if (rs.next()) {
                receipt.setId(rs.getLong("RECEIPT_ID"));
                Registration registration = new Registration();
                registration.setId(rs.getLong("REGISTER_ID"));
                receipt.setMedicineName(rs.getString("MEDICINE"));
                receipt.setRegistration(registration);
            }
        }
        return receipt;
    }

    @Override
    public void updateReceipt(Receipt receipt) throws Exception {
        String sql = "UPDATE RECEIPT SET MEDICINE=? , REGISTRATION_ID = ?"
                + "WHERE ID = ? ";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, receipt.getMedicineName());
            ps.setLong(2, receipt.getRegistration().getId());
            ps.setLong(3, receipt.getId());
            ps.execute();
            c.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
