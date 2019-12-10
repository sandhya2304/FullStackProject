package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.register.dao.UserRepository;



@CrossOrigin("*")
@RestController
@SpringBootApplication
public class UserRegistrationApplication
{
	
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping(value="/register")
	public String register(@RequestBody User user)
	{
		userRepository.save(user);
		
		return "Hi" +user.getName()+"welcome";
	}
	
	@GetMapping(value="/findAll")
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}
	
	@GetMapping(value="/findEmail/{email}")
	public List<User> getAllUsersByEmail(@PathVariable String email)
	{
		return userRepository.findByEmail(email);
	}
	
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteUser(@PathVariable int id)
	{
		userRepository.deleteById(id);
	}
	
	

	public static void main(String[] args) 
	{
		ApplicationContext cxt = SpringApplication.run(UserRegistrationApplication.class, args);
		UserRepository repo = (UserRepository) cxt.getBean(UserRepository.class);
	
	    repo.save(new User("ram","ram@gmail.com",3,"Telecom"));
	    repo.save(new User("abc","abc@gmail.com",2,"ecom"));
	    repo.save(new User("mona","mona@gmail.com",3,"Telecom"));
	    repo.save(new User("shyam","shyam@gmail.com",5,"Finance"));
	
	   
	     List<User> users = repo.findAll();
	     users.forEach(s -> System.out.println(s.getName()));
	
	
	
	
	
	}

}
