package ehospital.dao.impl;

import ehospital.dao.DbHelper;
import ehospital.model.Disease;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ehospital.dao.DiseaseDao;

public class DiseaseDaoImpl implements DiseaseDao {
    
    @Override
    public List<Disease> getDiseaseList() throws Exception {
        List<Disease> diseases = new ArrayList<>();
        String sql = "SELECT ID,NAME,TREATMENT,SYMPTOMS FROM DISEASE";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement pr = c.prepareStatement(sql);
                ResultSet rs = pr.executeQuery()) {
            while (rs.next()) {
                Disease disease = new Disease();
                disease.setID(rs.getLong("ID"));
                disease.setName(rs.getString("NAME"));
                disease.setTreatment(rs.getString("TREATMENT"));
                disease.setSymptoms(rs.getString("SYMPTOMS"));
                diseases.add(disease);
                
            }
        }
        return diseases;
    }
    
    @Override
    public Disease getDiseaseById(Long diseaseId) throws Exception {
        String sql = "SELECT ID,NAME FROM DISEASE\n"
                + "WHERE ID = ?";
        Disease disease = null;
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setLong(1, diseaseId);
            ResultSet rs = ps.executeQuery();
            disease = new Disease();
            if (rs.next()) {
                disease.setID(rs.getLong("ID"));
                disease.setName(rs.getString("NAME"));
            }
        }
        return disease;
    }
}
