package com.lwl.quizer.service;

public class TransactionDetailsDTO {
	
	private String mobile;
	private double amount;
	private String status;
	private String transactionId;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TransactionDetailsDTO [mobile=").append(mobile).append(", amount=").append(amount)
				.append(", status=").append(status).append(", transactionId=").append(transactionId).append("]");
		return builder.toString();
	}

	
}
