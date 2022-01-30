package ehospital.dao;

import ehospital.model.Disease;


import java.util.List;

public interface DiseaseDao {
    List<Disease> getDiseaseList() throws Exception;

    public Disease getDiseaseById(Long diseaseId)  throws Exception;
}
