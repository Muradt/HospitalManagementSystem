package ehospital.dao;

import ehospital.model.Doctor;
import ehospital.model.Registration;

import java.util.List;

public interface RegistrationDao {

    List<Registration> getRegistationList() throws Exception;

    void addRegistration(Registration registration) throws Exception;

    public List<Registration> getUnpaidRegistationList() throws Exception;

    public void deleteRegistration(Long registrationId);
    
    public void changeRegistrationStatus(Long registrationId,int registrationStatus) throws Exception;

    public Registration getRegistrationById(Long registrationId) throws Exception;

    public void updateRegistration(Registration registration) throws Exception;
    
    List<Registration> searchRegistrationData(String keyword) throws Exception;
}
