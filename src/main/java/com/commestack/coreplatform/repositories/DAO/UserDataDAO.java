package com.commestack.coreplatform.repositories.DAO;

import com.commestack.coreplatform.objects.entity.UserDataEntity;

import java.util.List;


public interface UserDataDAO {

    void save(UserDataEntity userDataEntity);

    UserDataEntity findById(Long id);

    List<UserDataEntity> findAll();

    UserDataEntity update(UserDataEntity userDataEntity);

    void delete(Long id);

    int deleteAll();

    UserDataEntity findByName(String firstName, String lastName);

    UserDataEntity updateLastNameById(Long id, String newLastName);
    int updateLastNamebyLastName(String oldLastName, String newLastName) ;

    }
