package com.example.demo.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ground_booking")
public class GroundBooking 
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int booking_id;
	private String date;
	private String time;
	private double price;
	private int userId;
	private int groundId;
	

	public GroundBooking() {
		super();
	}

	public GroundBooking(int booking_id, String date, String time, double price, int userId, int groundId) {
		super();
		this.booking_id = booking_id;
		this.date = date;
		this.time = time;
		this.price = price;
		this.userId = userId;
		this.groundId = groundId;
	}
	
}
