package com.zulo.model;

import java.util.ArrayList;
import java.util.List;

public class Location {
	private int locationId, distanceFromOrigin;
	private String name;
	private static int id = 1;
	List<Cab> cabs;

	public Location(int distanceFromOrigin, String name) {
		this.locationId = id++;
		this.distanceFromOrigin = distanceFromOrigin;
		this.name = name;
		this.cabs = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Cab> getCabs() {
		return cabs;
	}

	public void setCab(Cab cab) {
		cabs.add(cab);
	}

	public void removeCab(Cab cab) {
		cabs.remove(cab);
	}

	public int getLocationId() {
		return locationId;
	}

	public int getDistanceFromOrigin() {
		return distanceFromOrigin;
	}

	public boolean isNoCab() {
		return cabs.isEmpty();
	}
}
