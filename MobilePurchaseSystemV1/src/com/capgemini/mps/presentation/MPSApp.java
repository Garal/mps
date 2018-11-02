package com.capgemini.mps.presentation;

import java.util.Scanner;

import com.capgemini.mps.dto.Mobile;
import com.capgemini.mps.exception.MobilePurchaseException;
import com.capgemini.mps.service.IMobileService;
import com.capgemini.mps.service.MobileServiceImpl;

public class MPSApp {
	private static Scanner scanner=new Scanner(System.in);
	private static IMobileService mobileService = new MobileServiceImpl();
	
	public static void main(String[] args) {
		Mobile mobile=new Mobile();
		getMobileDetails(mobile);
		try{
		int n=addNewMobile(mobile);
		System.out.println(n);
		//Log success or failure status to logs
		}catch(MobilePurchaseException e){
		//Log Error Messages
		System.out.println(e.getMessage());
			
		}
		
	}

	private static int addNewMobile(Mobile mobile) throws MobilePurchaseException {
		// TODO Auto-generated method stub
		return mobileService.addNewMobile(mobile);
	}

	private static void getMobileDetails(Mobile mobile) {
		System.out.println("Enter Mobile Brand Name:");
		mobile.setName(scanner.nextLine());
		System.out.println("Enter Mobile Price:");
		mobile.setPrice(scanner.nextDouble());
		System.out.println("Enter Quantity:");
		mobile.setQuantity(scanner.nextInt());
		
	}

}
