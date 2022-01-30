package ehospital.dao;

import ehospital.model.Doctor;

import java.util.List;

public interface DoctorDao {

    List<Doctor> getDoctorList() throws Exception;

    List<Doctor> getLoginedDoctorList() throws Exception;

    void addDoctor(Doctor doctor) throws Exception;

    public void deleteDoctor(Long doctorId) throws Exception;

    public Doctor getDoctorbyId(Long doctorId) throws Exception;

    public void updateDoctor(Doctor d) throws Exception;

    List<Doctor> searchDoctorData(String keyword) throws Exception;
}
