package com.revature.models;

import java.time.LocalDate;

public class Request {

	private int r_id;
	private int e_id;
	private String description;
	private double amount;
	private LocalDate openDate;
	private LocalDate closeDate;
	private int resolved;
	
	public Request(int r_id, int e_id, String description, double amount, 
			LocalDate openDate, LocalDate closeDate, int resolved) {
		this.r_id = r_id;
		this.e_id = e_id;
		this.description = description;
		this.amount = amount;
		this.openDate = openDate;
		this.closeDate = closeDate;
		this.resolved = resolved;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getOpenDate() {
		return openDate;
	}
	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}
	public LocalDate getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(LocalDate closeDate) {
		this.closeDate = closeDate;
	}
	public int getIsResolved() {
		return resolved;
	}
	public void setResolved(int resolved) {
		this.resolved = resolved;
	}
	@Override
	public String toString() {
		return "Request [r_id=" + r_id + ", e_id=" + e_id + ", description=" + description + ", amount=" + amount
				+ ", openDate=" + openDate + ", closeDate=" + closeDate + ", resolved=" + resolved + "]";
	}
	
		
}
