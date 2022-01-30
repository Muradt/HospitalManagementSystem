/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital.service.impl;

import ehospital.dao.PatientDao;
import ehospital.model.Patient;
import ehospital.service.PatientService;
import java.util.List;

/**
 *
 * @author hp
 */
public class PatientServiceImpl implements PatientService {

    private PatientDao patientDao;

    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public List<Patient> getPatientList() throws Exception {
        return patientDao.getPatientList();
    }

    @Override
    public void addPatient(Patient patient) throws Exception {
        patientDao.addPatient(patient);
    }

    @Override
    public Patient getPatientbyId(Long patientId) throws Exception {
        return patientDao.getPatientbyId(patientId);
    }

    @Override
    public void updatePatient(Patient patient) throws Exception {
        patientDao.updatePatient(patient);
    }

    @Override
    public void deletePatient(Long patientId) throws Exception {
        patientDao.deletePatient(patientId);
    }

    @Override
    public List<Patient> searchPatientData(String keyword) throws Exception {
        return patientDao.searchPatientData(keyword);
    }

    @Override
    public List<Patient> getLoginedPatientList() throws Exception {
        return patientDao.getLoginedPatientList();
    }

}
