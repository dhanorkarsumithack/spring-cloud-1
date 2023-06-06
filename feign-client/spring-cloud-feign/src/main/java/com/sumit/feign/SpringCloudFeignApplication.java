package com.sumit.feign;

import com.sumit.feign.apiClient.UserClient;
import com.sumit.feign.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@EnableFeignClients
public class SpringCloudFeignApplication {

	@Autowired
	private UserClient userClient;

	@GetMapping("/findAllUser")
	public List<UserResponse> getAllUser(){
		return userClient.getUsers();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeignApplication.class, args);
	}

}
