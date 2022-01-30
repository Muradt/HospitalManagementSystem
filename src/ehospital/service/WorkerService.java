/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital.service;

import ehospital.model.Worker;
import java.util.List;

/**
 *
 * @author hp
 */
public interface WorkerService {

    List<Worker> getDoctorList() throws Exception;

    public List<Worker> getLoginedDoctorList() throws Exception;
}
