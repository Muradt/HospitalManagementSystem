package ehospital.dao;

import ehospital.model.Gender;

import java.util.List;

public interface Genderdao {

    List<Gender> getGenderList() throws Exception;
}
