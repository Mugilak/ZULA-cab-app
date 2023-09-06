package com.zulo.view;

import java.util.List;

import com.zulo.controller.OutputController;
import com.zulo.model.Cab;
import com.zulo.model.Location;
import com.zulo.model.Ride;
import com.zulo.model.User;

final class CustomerManage implements Manageable {
	private User currentCustomer;
	private String s = "s", d = "s";

	CustomerManage(User user) {
		this.currentCustomer = user;
	}

	@Override
	public void init() {
		String choice = "";
		do {
			showInstruction();
			choice = inp.next();
			process(choice);
		} while (!choice.equals("3"));
	}

	@Override
	public void showInstruction() {
		System.out.println("\n--------------------------");
		System.out.println("""
				1 . Hail a cab
				2 . Rides history
				3 . Logout
				""");
	}

	@Override
	public void process(String choice) {
		switch (choice) {
		case "1":
			bookCab();
			break;
		case "2":
			getRidesHistory();
			break;
		case "3":
			System.out.println("  You are Logged out");
			break;
		default:
			System.out.println("Invalid input");
		}
	}

	private void getRidesHistory() {
		System.out.println(
				"Id: " + currentCustomer.getUserId() + " | Name : " + currentCustomer.getName() + "\nTrip Details:");
		if (currentCustomer.getRides().isEmpty()) {
			System.out.println("   ~ No trips taken");
		} else {
			System.out.printf("|%-4s |%-8s |%-3s |%-5s\n", "Start", "destination", "cab Id", "Amount");
			for (Ride r : currentCustomer.getRides()) {
				System.out.printf("|%-5s |%-11s |%-6d |%-5d \n", r.getStart(), r.getDestination(),
						(int) r.getCabId(), (int) r.getAmount());
			}
		}
	}

	private void bookCab() {
		OutputController control = new OutputController();
		print(control.getLocations());
		getInput();
		if (!s.equals(d)) {
			Location start = control.isAvailable(s), dest = control.isAvailable(d);
			if (start != null && dest != null) {
				Cab onride = control.getNearestCab(start);
				if (onride != null) {
					int fair = control.calculateFair(start, dest);
					if (isConfimed(onride.getCabId(), fair)) {
						control.bookRide(start, dest, currentCustomer, onride, fair);
						System.out.println("cab " + onride.getCabId() + " is alloted | Driver Name: "
								+ onride.getDriver().getName() + "\n  ~~~ happy and safe journey ~~~");
					}else {
						System.out.println("cancelled");
					}
				} else {
					System.out.println("Sorry , No cabs available");
				}
			} else {
				System.out.println("Not Available Location");
			}
		} else {
			System.out.println("Invalid location");
		}
	}

	private boolean isConfimed(int cabId, int fair) {
		System.out.println("cab Id: " + cabId + " | fair : " + fair + " | source: " + s + " | destination: " + d
				+ "\n   Want to confirm this booking? (y / n) : ");
		char c = inp.next().charAt(0);
		if (c == 'Y' || c == 'y') {
			return true;
		}
		return false;
	}

	private void getInput() {
		System.out.println("Enter starting Location : ");
		s = inp.next();
		s = s.toUpperCase();
		System.out.println("Enter Destination to reach : ");
		d = inp.next();
		d = d.toUpperCase();
	}

	private void print(List<Location> locations) {
		System.out.println("Available cabs with location : ");
		System.out.printf("%-4s %-4s\n", "Location |", "Cab Ids");
		List<Cab> c = null;
		for (Location l : locations) {
			c = l.getCabs();
			if (!c.isEmpty()) {
				System.out.printf("%-8s %-1s", l.getName(), "|");
			} else {
				continue;
			}
			for (int i = 0; i < c.size(); i++) {
				System.out.printf("%2d", c.get(i).getCabId());
				if (i < c.size() - 1)
					System.out.print(",");
			}
			System.out.println();
		}
	}

}
