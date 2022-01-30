package ehospital.dao.impl;

import ehospital.dao.DbHelper;
import ehospital.dao.PaymentDao;
import ehospital.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentDaoImpl implements PaymentDao {

    @Override
    public List<Payment> getPaymentList() throws Exception {
        List<Payment> paymentList = new ArrayList<>();
        String sql = "select ROWNUM RR ,P.ID as PAYMENT_ID, P2.NAME AS PATIENT_NAME , P2.SURNAME AS PATIENT_SURNAME , D.NAME AS DOCTOR_NAME,D.SURNAME AS DOCTOR_SURNAME,D2.NAME AS DISEASE_NAME,P.TOTAL_AMOUNT AS AMOUNT, P.DATA_DATE AS PAYMENT_DATE from PAYMENT P\n"
                + "inner join REGISTRATION R on R.ID = P.REGISTER_ID\n"
                + "inner join PATIENT P2 on R.PATIENT_ID = P2.ID\n"
                + "inner join DOCTOR D on D.ID = R.DOCTOR_ID\n"
                + "inner JOIN DISEASE D2 on R.DISEASE_ID = D2.ID where R.status = 3 and P.status = 1";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Payment payment = new Payment();
                payment.setR(rs.getLong("RR"));
                payment.setId(rs.getLong("PAYMENT_ID"));
                payment.setTotalAmount(rs.getFloat("AMOUNT"));
                payment.setPaymentDate(rs.getDate("PAYMENT_DATE"));
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
                payment.setRegistration(registration);

                paymentList.add(payment);

            }

        }
        return paymentList;
    }

    @Override
    public void addPayment(Payment payment) throws Exception {
        String sql = "insert into Payment (ID,REGISTER_ID,TOTAL_AMOUNT)\n"
                + "VALUES (PAYMENT_SEQ.nextval,?,?)";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setLong(1, payment.getRegistration().getId());
            ps.setFloat(2, payment.getTotalAmount());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void deletePayment(Long paymentId) throws Exception {
        String sql = "UPDATE PAYMENT SET STATUS = 2 WHERE ID = ?";
        try (Connection c = DbHelper.getConnection();) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setLong(1, paymentId);
            ps.execute();
            c.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Payment getPaymentbyId(Long paymentId) throws Exception {
        String sql = "select ROWNUM RR ,P.ID as PAYMENT_ID, P2.NAME AS PATIENT_NAME , P2.SURNAME AS PATIENT_SURNAME , D.NAME AS DOCTOR_NAME,D.SURNAME AS DOCTOR_SURNAME,D2.NAME AS DISEASE_NAME,P.TOTAL_AMOUNT AS AMOUNT, P.DATA_DATE AS PAYMENT_DATE, R.ID AS register_id from PAYMENT P\n"
                + "inner join REGISTRATION R on R.ID = P.REGISTER_ID\n"
                + "inner join PATIENT P2 on R.PATIENT_ID = P2.ID\n"
                + "inner join DOCTOR D on D.ID = R.DOCTOR_ID\n"
                + "inner JOIN DISEASE D2 on R.DISEASE_ID = D2.ID where P.status  = 1 and P.ID= ?";
        Payment payment = null;
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setLong(1, paymentId);
            ResultSet rs = ps.executeQuery();
            payment = new Payment();
            if (rs.next()) {
                payment = new Payment();
                payment.setR(rs.getLong("RR"));
                payment.setId(rs.getLong("PAYMENT_ID"));
                payment.setTotalAmount(rs.getFloat("AMOUNT"));
                payment.setPaymentDate(rs.getDate("PAYMENT_DATE"));
                Registration registration = new Registration();
                registration.setId(rs.getLong("register_id"));
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
                payment.setRegistration(registration);
            }
        }
        return payment;
    }

    @Override
    public Payment getPaymentByRegisterId(long id) throws Exception {
        String sql = "select ROWNUM RR ,P.ID as PAYMENT_ID, P2.NAME AS PATIENT_NAME , P2.SURNAME AS PATIENT_SURNAME , D.NAME AS DOCTOR_NAME,D.SURNAME AS DOCTOR_SURNAME,D2.NAME AS DISEASE_NAME,P.TOTAL_AMOUNT AS AMOUNT, P.DATA_DATE AS PAYMENT_DATE from PAYMENT P\n"
                + "inner join REGISTRATION R on R.ID = P.REGISTER_ID\n"
                + "inner join PATIENT P2 on R.PATIENT_ID = P2.ID\n"
                + "inner join DOCTOR D on D.ID = R.DOCTOR_ID\n"
                + "inner JOIN DISEASE D2 on R.DISEASE_ID = D2.ID where R.ID= ?";
        Payment payment = null;
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                payment = new Payment();
                payment.setR(rs.getLong("RR"));
                payment.setId(rs.getLong("PAYMENT_ID"));
                payment.setTotalAmount(rs.getFloat("AMOUNT"));
                payment.setPaymentDate(rs.getDate("PAYMENT_DATE"));
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
                payment.setRegistration(registration);
            }
        }
        return payment;

    }

    @Override
    public void updatePayment(Payment payment) throws Exception {
        String sql = "UPDATE PAYMENT SET TOTAL_AMOUNT=?, REGISTER_ID = ?"
                + "WHERE ID = ? ";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setFloat(1, payment.getTotalAmount());
            ps.setLong(2, payment.getRegistration().getId());
            ps.setLong(3, payment.getId());
            ps.execute();
            c.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void changePaymentStatus(Long registrationId, int registrationStatus) throws Exception {
          String sql = "UPDATE PAYMENT SET STATUS = ? WHERE ID = ? ";
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
    public List<Payment> searchPaymentData(String keyword) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
