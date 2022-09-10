package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserSignupRIpo;
import com.example.demo.beans.User;



@Service
public class UserSignUpService 
{
	
	@Autowired
	//this autowierd give me sesster getter and bean defination for tha repo
	UserSignupRIpo repo;
	
	
	public List<User> getAll()
	{
		return repo.findAll();
	}
	
	public void delUser(int uid)
	{
		repo.deleteById(uid);
		
	}
	
	
	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(User players)  
	{  
	repo.save(players);  
	}
	
	public User getUserById(int uid)  
	{  
	return repo.findById(uid).get();  
	}
	
	public void update(User players, int uid)  
	{  
	repo.save(players);  
	}  
	 
	public void delete(int uid)  
	{  
	repo.deleteById(uid);  
	}  

}
