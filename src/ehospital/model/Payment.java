package ehospital.model;

import java.util.Date;

public class Payment extends HospitalModel {

    private float totalAmount;
    private Registration registration;
    private Date paymentDate;

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public static void showPayments(Payment payment) {
        System.out.println(payment.getR() + "--" + payment.registration.getPatient().getName() + "--" + payment.registration.getPatient().getSurName() + "--" + payment.registration.getDoctor().getName() + "--" + payment.registration.getDoctor().getSurName() + "--" + payment.getRegistration().getDisease().getName() + "--" + payment.getTotalAmount() + "--" + payment.getPaymentDate());
    }

    @Override
    public String toString() {
        return id + " " + registration.getPatient().getName() + " " + registration.getPatient().getSurName();
    }

}
