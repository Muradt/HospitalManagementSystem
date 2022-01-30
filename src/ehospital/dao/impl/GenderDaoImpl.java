package ehospital.dao.impl;

import ehospital.dao.DbHelper;
import ehospital.dao.Genderdao;
import ehospital.model.Doctor;
import ehospital.model.Gender;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GenderDaoImpl  implements Genderdao {
    @Override
    public List<Gender> getGenderList() throws Exception {
        List<Gender> genderList = new ArrayList<>();
        String sql = "select  ID,GENDER_NAME FROM GENDER";
        try (Connection c = DbHelper.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Gender gender = new Gender();
                gender.setID(rs.getLong("ID"));
                gender.setGenderName(rs.getString("GENDER_NAME"));
                genderList.add(gender);

            }

        }
        return genderList;
    }
}
