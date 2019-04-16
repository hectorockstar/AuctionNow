package com.auctionnow.exception;


public class AuctionNowServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String detail = "ERROR\n";
	
	public AuctionNowServiceException(String msg) {
		super(detail+msg);
	}
	

	public AuctionNowServiceException(String msg,Throwable cause){
		super(detail+msg,cause);
	}

}
