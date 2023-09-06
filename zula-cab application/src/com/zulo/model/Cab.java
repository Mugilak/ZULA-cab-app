package com.zulo.model;

import java.util.Stack;

public class Cab implements Comparable<Cab> {
	private static int id = 1;
	private int cabId, rest;
	private double earnings, totalZulaCommision;
	private User driver;
	private Stack<Ride> rides;

	public Cab(User driver) {
		this.driver = driver;
		this.rest = 0;
		this.cabId = id++;
		this.earnings = 0;
		this.totalZulaCommision = 0;
		this.rides = new Stack<>();
	}

	public Cab() {
		this.rest = 0;
		this.cabId = id++;
		this.earnings = 0;
		this.totalZulaCommision = 0;
		this.rides = new Stack<>();
	}

	public int getCabId() {
		return cabId;
	}

	public void setCabId(int cabId) {
		this.cabId = cabId;
	}

	public int getRest() {
		return rest;
	}

	public void setRest(int rest) {
		this.rest = rest;
	}

	public void updateRest() {
		this.rest -= 1;
	}

	public double getEarnings() {
		return earnings;
	}

	public void setEarnings(double earnings) {
		this.earnings = earnings;
	}

	public void addEarnings(double earnings) {
		this.earnings += earnings;
	}

	public double getTotalZulaCommision() {
		return totalZulaCommision;
	}

	public void setTotalZulaCommision(double totalZulaCommision) {
		this.totalZulaCommision = totalZulaCommision;
	}

	public void addTotalZulaCommision(double totalZulaCommision) {
		this.totalZulaCommision += totalZulaCommision;
	}

	public User getDriver() {
		return driver;
	}

	public void setDriver(User driver) {
		this.driver = driver;
	}

	public Stack<Ride> getRides() {
		return rides;
	}

	public void setRides(Stack<Ride> rides) {
		this.rides = rides;
	}

	public void setRides(Ride ride) {
		this.rides.push(ride);
	}

	@Override
	public int compareTo(Cab o) {
		return (rides.size() - o.getRides().size());
	}

	public int getTotalRides() {
		return this.rides.size();
	}

}
