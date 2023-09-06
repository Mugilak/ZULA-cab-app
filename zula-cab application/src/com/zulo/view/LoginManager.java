package com.zulo.view;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.zulo.controller.LoginController;
import com.zulo.model.Cab;
import com.zulo.model.Location;
import com.zulo.model.User;
import com.zulo.repository.ZulaDatabase;

public class LoginManager {
	String name, password;
	static {
		ZulaDatabase db = ZulaDatabase.getInstanceOf();
		// locations
		db.setLocations(new Location(0, "A"));
		db.setLocations(new Location(4, "B"));
		db.setLocations(new Location(7, "C"));
		db.setLocations(new Location(9, "D"));
		db.setLocations(new Location(15, "E"));
		db.setLocations(new Location(18, "F"));
		db.setLocations(new Location(20, "G"));
		db.setLocations(new Location(23, "H"));
		// drivers
		db.setUser(new User(23, "ee", "d1", 2));
		db.setUser(new User(25, "ff", "d2", 2));
		db.setUser(new User(35, "gg", "d3", 2));
		db.setUser(new User(45, "hh", "d4", 2));
		// customers
		db.setUser(new User(20, "aa", "u1", 0));
		db.setUser(new User(30, "bb", "u2", 0));
		db.setUser(new User(40, "cc", "u3", 0));
		db.setUser(new User(50, "dd", "u4", 0));
		//admin
		db.setUser(new User(50, "admin", "a1", 1));
		
		List<User> drivers = db.getUsers().stream().filter(x -> (x.getAccess() == 2)).toList();
		// cabs
		db.setCabs(new Cab(drivers.get(0)));
		db.setCabs(new Cab(drivers.get(1)));
		db.setCabs(new Cab(drivers.get(2)));
		db.setCabs(new Cab(drivers.get(3)));

		List<Cab> cabs = db.getCabs();
		for(int i=0;i<cabs.size();i++) {
			db.getUser(i).setCab(cabs.get(i));
		}
		db.getLocation(0).setCab(cabs.get(0));
		db.getLocation(3).setCab(cabs.get(1));
		db.getLocation(6).setCab(cabs.get(2));
		db.getLocation(3).setCab(cabs.get(3));
//		setCab(db);
	}

	public void makeLogin(int access, String string) {
		System.out.println(string + "'s login Portal");
		getInput();
		LoginController control = new LoginController();
		User user = control.isValidCredential(name, password, access);
		if (user != null) {
			System.out.println("you are logged in successfully!!");
			if (access == 0) {
				CustomerManage cus = new CustomerManage(user);
				cus.init();
			} else if (access == 1) {
				AdminManage a = new AdminManage(user);
				a.init();
			} else if (access == 2) {
				DriverManage d = new DriverManage(user);
				d.init();
			}
		} else {
			System.out.println("Invalid credentials!");
		}
	}

	private static void setCab(ZulaDatabase db) {
		List<Cab> cabs = db.getCabs();
		List<Location> location = db.getLocations();
		Random r = new Random();
		for (Cab c : cabs) {
			int i = r.nextInt(0, location.size());
			db.getLocation(i).setCab(c);
		}
	}

	private void getInput() {
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter username : ");
		name = inp.next();
		System.out.println("Enter password : ");
		password = inp.next();
	}

}
