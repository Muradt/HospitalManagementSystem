/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital.service.impl;

import ehospital.dao.DiseaseDao;
import ehospital.model.Disease;
import ehospital.service.DiseaseService;
import java.util.List;

/**
 *
 * @author hp
 */
public class DiseaseServiceImpl implements DiseaseService {

    private DiseaseDao diseaseDao;

    public DiseaseServiceImpl(DiseaseDao diseaseDao) {
        this.diseaseDao = diseaseDao;
    }

    @Override
    public List<Disease> getDiseaseList() throws Exception {
        return diseaseDao.getDiseaseList();
    }

    @Override
    public Disease getDiseaseById(Long diseaseId) throws Exception {
        return diseaseDao.getDiseaseById(diseaseId);
    }

}
