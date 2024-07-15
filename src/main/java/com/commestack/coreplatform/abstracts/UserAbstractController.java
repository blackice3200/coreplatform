package com.commestack.coreplatform.abstracts;

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

    protected UserDataEntity doUpdateUserLastNameById(Long id, String lastName) {


        return    userDataDAOImpl.updateLastNameById(id, lastName);

    }

    protected int doUpdateUsersLastNamebyLastName(String oldLastName,String newLastName) {

        return       userDataDAOImpl.updateLastNamebyLastName(oldLastName,newLastName);
    }


    protected void doDeleteUserById(Long id) {
        userDataDAOImpl.deleteUserById(id);

    }

    protected UserDataEntity doGetUserById(Long userId) {

       return userDataDAOImpl.findById(userId);
    }
}
