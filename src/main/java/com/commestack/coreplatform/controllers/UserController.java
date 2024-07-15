package com.commestack.coreplatform.controllers;


import com.commestack.coreplatform.abstracts.UserAbstractController;
import com.commestack.coreplatform.objects.models.CustomErrorResponse;
import com.commestack.coreplatform.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.commestack.coreplatform.objects.entity.UserDataEntity;

import java.sql.Date;

@RestController
@RequestMapping("/api")
public class UserController extends UserAbstractController {

    private static final String className="UserController";
    private String methodName="";
    @Value("${random.mapped.value}")
    private String randomMappedValue;

//TODO create a CRUD API for the users on the primary key
    @RequestMapping(method = RequestMethod.POST, value = "userRegistration")
        public UserDataEntity PostUserRegistration(@RequestParam(value = "username", required = true) String userName,
                                       @RequestParam(value = "password", required = true) String password,
                                       @RequestParam(value = "first_name", required = false) String fistName,
                                       @RequestParam(value = "last_name", required = false) String lastName,
                                       @RequestParam(value = "email", required = false) String email,
                                       @RequestParam(value = "birth_date", required = false) Date birthDate) {
        methodName="PostUserRegistration";


        UserDataEntity userDataEntity = new UserDataEntity(userName, password,fistName,lastName,email,birthDate);
        super.doUserRegistration(userDataEntity);
        System.out.println("Saving the students ...");


        return userDataEntity;
        }
    @RequestMapping(method = RequestMethod.GET, value = "allUsers")
    public String GetAllUsers() {
        methodName="GetAllUsers";

        super.doGetAllUsers();
        System.out.println("Saving the students ...");


        return "User have been saved successfully";
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUserByName")
    public String GetUserByName(@RequestParam(value = "first_name", required = true) String firstName,@RequestParam(value = "last_name", required = true) String lastName) {
        methodName="GetUserByName";

       UserDataEntity userDataEntity =  super.doGetUserByName(firstName,lastName);
        System.out.println(userDataEntity.toString());


        return "User have been saved successfully";
    }
    @RequestMapping(method = RequestMethod.GET, value = "getUserById")
    public UserDataEntity GetUserById(@RequestParam(value = "user_id", required = true) Long userId) {
        methodName="GetUserById";

        UserDataEntity userDataEntity =  super.doGetUserById(userId);
        if(userDataEntity ==null)
        {
            throw new UserNotFoundException("User not found");
        }
        System.out.println(userDataEntity.toString());


        return userDataEntity;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUpdateUserLastNameById")
    public String GetUpdateUserLastNameById(@RequestParam(value = "id", required = true) Long id,@RequestParam(value = "last_name", required = true) String lastName) {
        methodName="GetUserByName";

        UserDataEntity userDataEntity =  super.doUpdateUserLastNameById(id,lastName);
        System.out.println(userDataEntity.toString());

        return "User have been saved successfully";
    }



    @RequestMapping(method = RequestMethod.GET, value = "getUpdateUsersLastNamebyLastName")
    public String GetUpdateUserLastNameById(@RequestParam(value = "old_last_name", required = true) String oldLastName, @RequestParam(value = "new_last_name", required = true) String newLastName) {
        methodName="GetUserByName";

        int numOfRowsUpdated =  super.doUpdateUsersLastNamebyLastName(oldLastName,newLastName);

        System.out.println("Number of Rows Updated is : "+numOfRowsUpdated);



        return "User have been saved successfully";
    }


        @RequestMapping(method = RequestMethod.GET, value = "getDeleteUserById")
    public String GetDeleteUserById(@RequestParam(value = "id", required = true) Long id) {
        methodName="getDeleteUserById";

        super.doDeleteUserById(id);

        return "User have been Deleted successfully";
    }





}
