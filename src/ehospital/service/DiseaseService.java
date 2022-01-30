/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital.service;

import ehospital.model.Disease;
import java.util.List;

/**
 *
 * @author hp
 */
public interface DiseaseService {
    List<Disease> getDiseaseList() throws Exception;

    public Disease getDiseaseById(Long diseaseId) throws Exception;
    
}
