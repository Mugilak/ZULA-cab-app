package com.zulo.repository;

import java.util.ArrayList;
import java.util.List;

import com.zulo.model.Cab;
import com.zulo.model.Location;
import com.zulo.model.User;

public class ZulaDatabase {
	private static ZulaDatabase db;
	private List<Location> locations;
	private List<Cab> cabs;
	private List<User> users;
//	customer, driver, admin;

	private ZulaDatabase() {
		this.locations = new ArrayList<>();
		this.users = new ArrayList<>();
		this.cabs = new ArrayList<>();
	}

	public static ZulaDatabase getInstanceOf() {
		if (db == null) {
			db = new ZulaDatabase();
		}
		return db;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public Location getLocation(int index) {
		return locations.get(index);
	}

	public void setLocations(Location location) {
		this.locations.add(location);
	}

	public List<Cab> getCabs() {
		return cabs;
	}

	public Cab getCab(int index) {
		return cabs.get(index);
	}

	public void setCabs(Cab cab) {
		this.cabs.add(cab);
	}

	public List<User> getUsers() {
		return users;
	}

	public User getUser(int index) {
		return users.get(index);
	}

	public void setUser(User user) {
		this.users.add(user);
	}
//	public List<User> getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(User customer) {
//		this.customer.add(customer);
//	}
//
//	public List<User> getDriver() {
//		return driver;
//	}
//
//	public void setDriver(User driver) {
//		this.driver.add(driver);
//	}

}
