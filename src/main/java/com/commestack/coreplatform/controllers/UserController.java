package com.commestack.coreplatform.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.commestack.coreplatform.objects.entity.UserDataEntity;

import java.sql.Date;

@RestController
public class UserController extends UserAbstractController {

    private static final String className="UserController";
    private String methodName="";
    @Value("${random.mapped.value}")
    private String randomMappedValue;


    @RequestMapping(method = RequestMethod.POST, value = "userRegistration")
        public String PostUserRegistration(@RequestParam(value = "username", required = true) String userName,
                                       @RequestParam(value = "password", required = true) String password,
                                       @RequestParam(value = "first_name", required = false) String fistName,
                                       @RequestParam(value = "last_name", required = false) String lastName,
                                       @RequestParam(value = "email", required = false) String email,
                                       @RequestParam(value = "birth_date", required = false) Date birthDate) {
        methodName="PostUserRegistration";


        UserDataEntity userDataEntity = new UserDataEntity(userName, password,fistName,lastName,email,birthDate);
        super.doUserRegistration(userDataEntity);
        System.out.println("Saving the students ...");


        return "User have been saved successfully";
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


}
