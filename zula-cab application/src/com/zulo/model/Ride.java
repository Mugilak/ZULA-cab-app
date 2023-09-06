package com.zulo.model;

public class Ride {
	private String start, destination;
	private User user;
	private Cab cab;
	private double amount, zuloCommision;

	public Ride(String start, String destination, User user, Cab cab, double amount, double zuloCommision) {
		super();
		this.start = start;
		this.destination = destination;
		this.user = user;
		this.amount = amount;
		this.cab = cab;
		this.zuloCommision = zuloCommision;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getUserId() {
		return user.getUserId();
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getZuloCommision() {
		return zuloCommision;
	}

	public void setZuloCommision(double zuloCommision) {
		this.zuloCommision = zuloCommision;
	}

	public int getCabId() {
		return cab.getCabId();
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

}
