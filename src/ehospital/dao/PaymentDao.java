package ehospital.dao;

import ehospital.model.Doctor;
import ehospital.model.Payment;

import java.util.List;

public interface PaymentDao {

    List<Payment> getPaymentList() throws Exception;

    void addPayment(Payment payment) throws Exception;

    public void deletePayment(Long paymentId) throws Exception;

    public Payment getPaymentbyId(Long paymentId) throws Exception;

    public Payment getPaymentByRegisterId(long id) throws Exception;

    public void updatePayment(Payment payment) throws Exception;

    public void changePaymentStatus(Long registrationId, int registrationStatus) throws Exception;
    
    List<Payment> searchPaymentData(String keyword) throws Exception;

}
