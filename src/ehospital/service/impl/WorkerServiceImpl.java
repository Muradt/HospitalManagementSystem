/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital.service.impl;

import ehospital.dao.WorkerDao;
import ehospital.model.Worker;
import ehospital.service.WorkerService;
import java.util.List;

/**
 *
 * @author hp
 */
public class WorkerServiceImpl implements WorkerService {

    private WorkerDao workerDao;

    public WorkerServiceImpl(WorkerDao workerDao) {
        this.workerDao = workerDao;
    }

    @Override
    public List<Worker> getDoctorList() throws Exception {
        return workerDao.getDoctorList();
    }

    @Override
    public List<Worker> getLoginedDoctorList() throws Exception {
        return workerDao.getLoginedDoctorList();
    }

}
