package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.beans.User;

public interface UserSignupRIpo extends JpaRepository<User, Integer> 
{
	

}
