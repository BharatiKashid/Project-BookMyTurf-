package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.beans.GroundBooking;
import com.example.demo.beans.User;

public interface GroundBookingRIpo extends JpaRepository<GroundBooking,Integer> {

	@Query("select g.booking_id from GroundBooking g where date=:d and time=:t")
	public int getBookId(String d,String t);
	
	@Query("select u from User u where u.email=:email and u.pass=:pass")
	public User checkLogin(String email,String pass);
	
}
