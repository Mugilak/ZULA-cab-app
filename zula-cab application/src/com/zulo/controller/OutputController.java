package com.zulo.controller;

import java.util.Collections;
import java.util.List;

import com.zulo.model.Cab;
import com.zulo.model.Location;
import com.zulo.model.Ride;
import com.zulo.model.User;
import com.zulo.repository.ZulaDatabase;

public class OutputController {
	ZulaDatabase db = ZulaDatabase.getInstanceOf();
	Location cabLoc;

	public List<Location> getLocations() {
		return db.getLocations();
	}

	public int calculateFair(Location start, Location dest) {
		int distance = Math.abs(start.getDistanceFromOrigin() - dest.getDistanceFromOrigin());
		return distance * 10;
	}

	public Cab getNearestCab(Location start) {
		int sDist = start.getDistanceFromOrigin();
		int min = Integer.MAX_VALUE;
		Cab minCab = null;
		cabLoc = null;
		for (Location l : db.getLocations()) {
			if (l.isNoCab()) {
				continue;
			}
			Collections.sort(l.getCabs());
			if (Math.abs(sDist - l.getDistanceFromOrigin()) < min) {
				for (Cab c : l.getCabs()) {
					if (c.getRest() <= 0) {
						min = Math.abs(sDist - l.getDistanceFromOrigin());
						minCab = c;
						cabLoc = l;
						break;
					}
				}
			}
		}
		return minCab;
	}

	public Location isAvailable(String s) {
		List<Location> l = db.getLocations().stream().filter(x -> (x.getName().equals(s))).toList();
		if (l.isEmpty() || l == null)
			return null;
		return l.get(0);
	}

	public void bookRide(Location start, Location dest, User customer, Cab onride, int fair) {
		double zc = fair * 0.3;
		Ride ride = new Ride(start.getName(), dest.getName(), customer, onride, (double) fair, zc);
		updateRest(onride);
		onride.setRest(1);
		onride.addEarnings(fair);
		onride.addTotalZulaCommision(zc);
		onride.setRides(ride);

		cabLoc.removeCab(onride);
		dest.setCab(onride);

		customer.setRides(ride);
	}

	private void updateRest(Cab onride) {
		db.getCabs().stream().filter(x -> x.getRest() > 0).forEach(x -> x.updateRest());
	}

	public List<Cab> getCabs() {
		return db.getCabs();
	}

}
