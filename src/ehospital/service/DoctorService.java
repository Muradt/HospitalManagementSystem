/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital.service;

import ehospital.model.Doctor;
import java.util.List;

/**
 *
 * @author hp
 */
public interface DoctorService {

    List<Doctor> getDoctorList() throws Exception;

    List<Doctor> getLoginedDoctorList() throws Exception;

    void addDoctor(Doctor doctor) throws Exception;

    public void deleteDoctor(Long doctorId) throws Exception;

    public Doctor getDoctorbyId(Long doctorId) throws Exception;

    public void updateDoctor(Doctor d) throws Exception;

    List<Doctor> searchDoctorData(String keyword) throws Exception;
}
