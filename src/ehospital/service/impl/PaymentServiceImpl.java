/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital.service.impl;

import ehospital.dao.PaymentDao;
import ehospital.model.Payment;
import ehospital.service.PaymentService;
import java.util.List;

/**
 *
 * @author hp
 */
public class PaymentServiceImpl implements PaymentService {

    private PaymentDao paymentDao;

    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public List<Payment> getPaymentList() throws Exception {
        return paymentDao.getPaymentList();
    }

    @Override
    public void addPayment(Payment payment) throws Exception {
        paymentDao.addPayment(payment);
    }

    @Override
    public void deletePayment(Long paymentId) throws Exception {
        paymentDao.deletePayment(paymentId);
    }

    @Override
    public Payment getPaymentbyId(Long paymentId) throws Exception {
        return paymentDao.getPaymentbyId(paymentId);
    }

    @Override
    public void updatePayment(Payment payment) throws Exception {
        paymentDao.updatePayment(payment);
    }

    @Override
    public Payment getPaymentByRegisterId(long id) throws Exception {
        return paymentDao.getPaymentByRegisterId(id);
    }

    @Override
    public void changePaymentStatus(Long registrationId, int registrationStatus) throws Exception {
        paymentDao.changePaymentStatus(registrationId, registrationStatus);
    }

    @Override
    public List<Payment> searchPaymentData(String keyword) throws Exception {
        return paymentDao.searchPaymentData(keyword);
    }

}
