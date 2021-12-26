package com.practical.test.jwt;

import com.practical.test.jwt.entity.User;
import com.practical.test.jwt.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@CrossOrigin("*")
public class JWTApplication {

	@Autowired
	AuthRepository repository;

	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
				new User(101, "admin", "admin","Tharanga Dilshan","galle","TharangaDil98@gmail.com"),
				new User(102, "user1", "pwd1","user one ","galle","userOne@gmail.com")
		).collect(Collectors.toList());
		repository.saveAll(users);
	}



	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("*").allowedMethods("*");
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(JWTApplication.class, args);
	}

}
