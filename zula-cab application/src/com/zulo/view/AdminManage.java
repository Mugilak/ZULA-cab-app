package com.zulo.view;

import java.util.List;

import com.zulo.controller.OutputController;
import com.zulo.model.Cab;
import com.zulo.model.Ride;
import com.zulo.model.User;

public class AdminManage implements Manageable {

	public AdminManage(User user) {
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
				1 . All Cab Details
				2 . Logout
				""");
	}

	@Override
	public void process(String choice) {
		switch (choice) {
		case "1":
			getCabData();
			break;
		case "2":
			System.out.println("  You are Logged out");
			break;
		default:
			System.out.println("Invalid input");
		}
	}

	private void getCabData() {
		OutputController output = new OutputController();
		List<Cab> cabs = output.getCabs();
		for (Cab c : cabs) {
			System.out.println("Cab Id: " + c.getCabId() + "\nNo.of Trips: " + c.getTotalRides() + " | Earnings: "
					+ c.getEarnings() + "\nTotal ZULA Commission: " + c.getTotalZulaCommision() + "\nTrips taken :");
			if (c.getTotalRides() <= 0) {
				System.out.println(" ~ no trips were given");
			} else {
				System.out.printf("|%-4s |%-8s |%-3s |%-7s |%-5s\n", "Start", "destination", "Customer Id",
						"ZULA Commission", "Amount");
				for (Ride r : c.getRides()) {
					System.out.printf("|%-5s |%-11s |%-11d |%-15d |%-3d \n", r.getStart(), r.getDestination(),
							r.getUserId(), (int) r.getZuloCommision(), (int) r.getAmount());
				}
			}
			System.out.println();
		}
	}

}
