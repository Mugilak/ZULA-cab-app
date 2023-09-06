package com.zulo.view;

import com.zulo.model.Ride;
import com.zulo.model.User;

public class DriverManage implements Manageable {
	User currentDriver;

	public DriverManage(User user) {
		currentDriver = user;
	}

	@Override
	public void init() {
		String choice = "";
		do {
			showInstruction();
			choice = inp.next();
			process(choice);
		} while (!choice.equals("2"));
	}

	@Override
	public void showInstruction() {
		System.out.println();
		System.out.println("""
				1 . Rides history
				2 . Logout
				""");
	}

	@Override
	public void process(String choice) {
		switch (choice) {
		case "1":
			getHistory();
			break;
		case "2":
			System.out.println("  You are Logged out");
			break;
		default:
			System.out.println("Invalid input");
		}
	}

	private void getHistory() {
		System.out.println("Id: " + currentDriver.getUserId() + " | Name : " + currentDriver.getName()
				+ " | Earnings : " + currentDriver.getEarnings() + "\nTrip Details:");
		if (currentDriver.getCab().getRides().isEmpty()) {
			System.out.println("   ~ No trips taken");
		} else {
			System.out.printf("|%-4s |%-8s |%-3s |%-7s |%-5s\n", "Start", "destination", "Customer Id",
					"ZULA Commission", "Amount");
			for (Ride r : currentDriver.getCab().getRides()) {
				System.out.printf("|%-5s |%-11s |%-11d |%-15d |%-3d \n", r.getStart(), r.getDestination(),
						r.getUserId(), (int) r.getZuloCommision(), (int) r.getAmount());
			}
		}
	}

}
