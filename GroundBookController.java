package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.GroundBooking;
import com.example.demo.beans.Newground;
import com.example.demo.beans.User;
import com.example.demo.services.GroundBookService;



@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/ground")
public class GroundBookController 
{
	@Autowired
	GroundBookService groundServiceImpl;
	
	
	@GetMapping("/get")
	public List<Newground> diplayAllgrd(){
		return groundServiceImpl.displayAll();
	}
	//Users u1=userSignupService.getById(u.getId())
	
	@PostMapping("/addbook")
	public GroundBooking addBookings(@RequestBody GroundBooking booking) {
		System.out.println("inside controller ->"+booking);
		return groundServiceImpl.addBookings(booking);
	}
	
	
	
	@GetMapping("/getBid")
	public int getBookId(@RequestParam("date")String d,@RequestParam("time")String t)
	{
		return groundServiceImpl.getBookId(d,t);
	}

	@GetMapping("/login")
	public User checkLogin(@RequestParam String email,@RequestParam String pass)
	{
		return groundServiceImpl.checkLogin(email,pass);
	}
}
