package ehospital.main;

import ehospital.dao.*;
import ehospital.dao.impl.*;
import ehospital.dao.PatientDao;
import ehospital.gui.main.MainFrame;
import ehospital.gui.login.LoginFrame;
import ehospital.gui.main.DoctorMainFrame;
import ehospital.service.DiseaseService;
import ehospital.service.DoctorService;
import ehospital.service.PatientService;
import ehospital.service.PaymentService;
import ehospital.service.ReceiptService;
import ehospital.service.RegistrationService;
import ehospital.service.RoomService;
import ehospital.service.impl.DiseaseServiceImpl;
import ehospital.service.impl.DoctorServiceImpl;
import ehospital.service.impl.PatientServiceImpl;
import ehospital.service.impl.PaymentServiceImpl;
import ehospital.service.impl.ReceiptServiceImpl;
import ehospital.service.impl.RegistrationServiceImpl;
import ehospital.service.impl.RoomServiceImpl;

public class Main {

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    LoginFrame lg = new LoginFrame();
                    lg.setVisible(true);
                    break;
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
