package com.zulo.model;

import java.util.Stack;

public class User {
	private static int id = 1;
	private int access, age, userId, earnings;
	private String name, password;
	private Stack<Ride> rides;
	private Cab cab;

	public User(int age, String name, String password, int access) {
		this.userId = id++;
		this.age = age;
		this.name = name;
		this.password = password;
		this.access = access;
		if (access == 0)
			this.rides = new Stack<>();
	}

	public int getAccess() {
		return access;
	}

	public void setAccess(int access) {
		this.access = access;
	}

	public boolean isAdmin() {
		return access == 1;
	}

	public boolean isDriver() {
		return access == 2;
	}

	public boolean isCustomer() {
		return access == 0;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Stack<Ride> getRides() {
		if (access == 0)
			return rides;
		return null;
	}

	public void setRides(Stack<Ride> rides) {
		if (access == 0)
			this.rides = rides;
	}

	public void setRides(Ride ride) {
		if (access == 0)
			this.rides.push(ride);
	}

	public Cab getCab() {
		if (access == 2)
			return cab;
		return null;
	}

	public void setCab(Cab cab) {
		if (access == 2)
			this.cab = cab;
	}

	public int getEarnings() {
		return earnings;
	}

	public void addEarnings(int e) {
		earnings += e;
	}

}
