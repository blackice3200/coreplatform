package com.commestack.coreplatform.controllers;

import com.commestack.coreplatform.objects.entity.UserDataEntity;
import com.commestack.coreplatform.repositories.DAOImpl.UserDataDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserAbstractController {
private final String className="UserAbstractController";
private String methodName="";
    @Autowired
    UserDataDAOImpl userDataDAOImpl;

    protected void doUserRegistration(UserDataEntity userDataEntity) {
        methodName="doUserRegistration";
        userDataDAOImpl.save(userDataEntity);

    }

    protected void doGetAllUsers() {
        methodName="doGetAllUsers";

        List<UserDataEntity> userDataEntityList= userDataDAOImpl.findAll();

        for(UserDataEntity userDataEntity : userDataEntityList ){
            System.out.println(userDataEntity.toString());
        }

    }

    protected UserDataEntity doGetUserByName(String firstName, String lastName) {
        methodName="doGetUserByName";

        UserDataEntity userDataEntity=userDataDAOImpl.findByName(firstName,lastName);
        return userDataEntity;

    }
}
