/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital.service;

import ehospital.model.Payment;
import java.util.List;

/**
 *
 * @author hp
 */
public interface PaymentService {

    List<Payment> getPaymentList() throws Exception;

    void addPayment(Payment payment) throws Exception;

    public void deletePayment(Long paymentId) throws Exception;
    
    public Payment getPaymentbyId(Long paymentId) throws Exception;

    public void updatePayment(Payment payment) throws Exception;

    public Payment getPaymentByRegisterId(long id) throws Exception;
    
    public void changePaymentStatus(Long registrationId, int registrationStatus) throws Exception;
    
    List<Payment> searchPaymentData(String keyword) throws Exception;
}
