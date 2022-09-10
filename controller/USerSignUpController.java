package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.User;
import com.example.demo.services.UserSignUpService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class USerSignUpController 
{
	//controller decides use of service method as per requirement
			@Autowired
			UserSignUpService sservice ;

			//controller is used for mapping the request Url
			@GetMapping("/all")
			public List<User> getAllData()
			{
				//no view resolver is needed
				//no data in the form of html.view
				//data is is json format
				return sservice.getAll();
			}

			@GetMapping("/deletuser/{uid}")
			public void deleteUser1(@PathVariable("uid") int pid)
			{
				sservice.delUser(pid);
			}
			
			@PostMapping(value = "/save")
			private long saveBook(@RequestBody User players)  
			{  
				sservice.saveOrUpdate(players);  
			return  players.getId();  
			}
			  
			@RequestMapping("/player/{uid}")  
			private User getUser(@PathVariable(name = "uid") int playerid)  
			{  
			return sservice.getUserById(playerid);  
			}  
			    
			@PutMapping("/edit/{uid}")
			 
			    private User update(@RequestBody User players)  
			    {  
				sservice.saveOrUpdate(players);  
			       return players;  
			    }  
			 
			@DeleteMapping("/delete/{uid}")  
			private void deleteUser(@PathVariable("uid") int id)  
			{  
				sservice.delete(id);  
			}  
			
			
}
