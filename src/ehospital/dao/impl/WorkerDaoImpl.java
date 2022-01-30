/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital.dao.impl;

import ehospital.dao.DbHelper;
import ehospital.dao.WorkerDao;
import ehospital.model.Patient;
import ehospital.model.Worker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class WorkerDaoImpl implements WorkerDao {

    @Override
    public List<Worker> getDoctorList() throws Exception {
        List<Worker> workerList = new ArrayList<>();
        String sql = "SELECT  ROWNUM R,ID,NAME,SURNAME,EMAIL,PHONE,LOGIN,PASSWORD FROM WORKER\n"
                + "WHERE ACTIVE = 1";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Worker worker = new Worker();
                worker.setR(rs.getLong("R"));
                worker.setId(rs.getLong("ID"));
                worker.setName(rs.getString("NAME"));
                worker.setSurName(rs.getString("SURNAME"));
                worker.setEmail(rs.getString("EMAIL"));
                worker.setPhone(rs.getString("PHONE"));
                worker.setLogin(rs.getString("LOGIN"));
                worker.setPassword(rs.getString("PASSWORD"));
                workerList.add(worker);

            }

        }
        return workerList;
    }

    @Override
    public List<Worker> getLoginedDoctorList() throws Exception {
          List<Worker> workerList = new ArrayList<>();
        String sql = "SELECT  LOGIN,PASSWORD FROM WORKER\n"
                + "WHERE ACTIVE = 1 and LOGIN is not null and PASSWORD is not null";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Worker worker = new Worker();
                worker.setLogin(rs.getString("LOGIN"));
                worker.setPassword(rs.getString("PASSWORD"));
                workerList.add(worker);

            }

        }
        return workerList;
    }

}
