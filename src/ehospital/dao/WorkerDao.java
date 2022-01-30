/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital.dao;

import ehospital.model.Worker;
import java.util.List;

/**
 *
 * @author hp
 */
public interface WorkerDao {

    List<Worker> getDoctorList() throws Exception;

    List<Worker> getLoginedDoctorList() throws Exception;
}
