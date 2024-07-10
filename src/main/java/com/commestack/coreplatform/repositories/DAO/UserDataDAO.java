package com.commestack.coreplatform.repositories.DAO;

import com.commestack.coreplatform.objects.entity.UserDataEntity;

import java.util.List;


public interface UserDataDAO {

    void save(UserDataEntity userDataEntity);

    UserDataEntity findById(Integer id);

    List<UserDataEntity> findAll();

    void update(UserDataEntity theStudent);

    void delete(Integer id);

    int deleteAll();

    UserDataEntity findByName(String firstName, String lastName);
}
