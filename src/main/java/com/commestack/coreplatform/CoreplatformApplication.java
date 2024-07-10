package com.commestack.coreplatform;

import com.commestack.coreplatform.objects.entity.UserDataEntity;
import com.commestack.coreplatform.repositories.DAO.UserDataDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CoreplatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreplatformApplication.class, args);
	}

}
