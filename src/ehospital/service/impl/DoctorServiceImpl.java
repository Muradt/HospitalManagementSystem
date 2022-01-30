/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital.service.impl;

import ehospital.dao.DoctorDao;
import ehospital.model.Doctor;
import ehospital.service.DoctorService;
import java.util.List;

/**
 *
 * @author hp
 */
public class DoctorServiceImpl implements DoctorService {

    private DoctorDao doctorDao;

    public DoctorServiceImpl(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    @Override
    public List<Doctor> getDoctorList() throws Exception {
        return doctorDao.getDoctorList();
    }

    @Override
    public void addDoctor(Doctor doctor) throws Exception {
        doctorDao.addDoctor(doctor);
    }

    @Override
    public void deleteDoctor(Long doctorId) throws Exception {
        doctorDao.deleteDoctor(doctorId);
    }

    @Override
    public Doctor getDoctorbyId(Long doctorId) throws Exception {
        return doctorDao.getDoctorbyId(doctorId);
    }

    @Override
    public void updateDoctor(Doctor d) throws Exception {
        doctorDao.updateDoctor(d);
    }

    @Override
    public List<Doctor> searchDoctorData(String keyword) throws Exception {
        return doctorDao.searchDoctorData(keyword);
    }

    @Override
    public List<Doctor> getLoginedDoctorList() throws Exception {
        return doctorDao.getLoginedDoctorList();
    }

}
