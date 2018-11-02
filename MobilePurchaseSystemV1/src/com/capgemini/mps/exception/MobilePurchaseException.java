package com.capgemini.mps.exception;

public class MobilePurchaseException extends Exception {

	
	private String status;
	public MobilePurchaseException(){
		status="Mobile Purchase Exception";
	
	}
	public MobilePurchaseException(String status) {
		super();
		this.status = status;
	}
	@Override
	public String toString() {
		return "MobilePurchaseException [status=" + status + "]";
	}
	public String getStatus() {
		return status;
	}
	
	
}
