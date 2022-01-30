package ehospital.dao;

import ehospital.model.Patient;

import java.util.List;

public interface PatientDao {

    List<Patient> getPatientList() throws Exception;

    List<Patient> getLoginedPatientList() throws Exception;

    void addPatient(Patient patient) throws Exception;

    Patient getPatientbyId(Long patientId) throws Exception;

    public void updatePatient(Patient patient);

    public void deletePatient(Long patientId) throws Exception;

    List<Patient> searchPatientData(String keyword) throws Exception;

}
