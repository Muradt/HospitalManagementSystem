/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital.service;

import ehospital.model.Patient;
import java.util.List;

/**
 *
 * @author hp
 */
public interface PatientService {

    List<Patient> getPatientList() throws Exception;

    List<Patient> getLoginedPatientList() throws Exception;

    void addPatient(Patient patient) throws Exception;

    Patient getPatientbyId(Long patientId) throws Exception;

    void updatePatient(Patient patient) throws Exception;

    void deletePatient(Long patientId) throws Exception;

    List<Patient> searchPatientData(String keyword) throws Exception;
}
