/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital.service;

import ehospital.model.Registration;
import java.util.List;

/**
 *
 * @author hp
 */
public interface RegistrationService {

    List<Registration> getRegistationList(int choice) throws Exception;

    void addRegistration(Registration registration) throws Exception;

    public void deleteRegistration(Long registrationId);

    public void changeRegistrationStatus(Long registrationId,int registrationStatus) throws Exception;

    public Registration getRegistrationById(Long registrationId)throws Exception;

    public void updateRegistration(Registration registration) throws Exception;
    
    List<Registration> searchRegistrationData(String keyword) throws Exception;
}
