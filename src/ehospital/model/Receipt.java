package ehospital.model;

public class Receipt extends HospitalModel {
    private Registration registration;
    private String medicineName;

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public static void showReceipt(Receipt receipt) {
        System.out.println(receipt.getR() + "--" + receipt.getRegistration().getPatient().getName() + "--" + receipt.getRegistration().getPatient().getSurName() + "--" + receipt.getRegistration().getDoctor().getName() + "--" + receipt.getRegistration().getDoctor().getSurName()+"--"+receipt.getMedicineName()+"--"+receipt.getData_date());
    }
    
}
