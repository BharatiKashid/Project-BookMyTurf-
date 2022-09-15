package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.GroundBookingRIpo;
import com.example.demo.Repository.NewGroundRepo;
import com.example.demo.Repository.UserSignupRIpo;
import com.example.demo.beans.GroundBooking;
import com.example.demo.beans.Newground;
import com.example.demo.beans.User;


@Service
public class GroundBookService 
{
	@Autowired
	NewGroundRepo groundripo;

	@Autowired
	GroundBookingRIpo groundBookingripo;
	
	@Autowired
	UserSignupRIpo usersignupripo;
	
	public List<Newground> displayAll() {
		return groundripo.findAll();
	}

	public GroundBooking addBookings(GroundBooking booking) {
		return groundBookingripo.save(booking);
			
	}
	
	public int getBookId(String d,String t)
	{
		return groundBookingripo.getBookId(d,t);
	}
	
	public User checkLogin(String email, String pass) {
		return usersignupripo.checkLogin(email, pass);
	}


}
