/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital.service.impl;

import ehospital.dao.RegistrationDao;
import ehospital.model.Registration;
import ehospital.service.RegistrationService;
import java.util.List;

/**
 *
 * @author hp
 */
public class RegistrationServiceImpl implements RegistrationService {

    private RegistrationDao registrationDao;

    public RegistrationServiceImpl(RegistrationDao registrationDao) {
        this.registrationDao = registrationDao;
    }

    @Override
    public List<Registration> getRegistationList(int choice) throws Exception {
        if (choice == 1) {
            return registrationDao.getRegistationList();
        } else {
            return registrationDao.getUnpaidRegistationList();

        }
    }

    @Override
    public void addRegistration(Registration registration) throws Exception {
        registrationDao.addRegistration(registration);
    }

    @Override
    public void deleteRegistration(Long registrationId) {
        registrationDao.deleteRegistration(registrationId);
    }

    @Override
    public void changeRegistrationStatus(Long registrationId, int registrationStatus) throws Exception {
        registrationDao.changeRegistrationStatus(registrationId, registrationStatus);
    }

    @Override
    public Registration getRegistrationById(Long registrationId) throws Exception {
        return registrationDao.getRegistrationById(registrationId);
    }

    @Override
    public void updateRegistration(Registration registration) throws Exception {
        registrationDao.updateRegistration(registration);
    }

    @Override
    public List<Registration> searchRegistrationData(String keyword) throws Exception {
        return registrationDao.searchRegistrationData(keyword);
    }

}
