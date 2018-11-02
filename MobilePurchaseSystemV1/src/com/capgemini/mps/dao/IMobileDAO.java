package com.capgemini.mps.dao;

import java.util.List;

import com.capgemini.mps.dto.Mobile;
import com.capgemini.mps.exception.MobilePurchaseException;

public interface IMobileDAO {
	
		
		public abstract Integer addNewMobile(Mobile mobile)throws MobilePurchaseException;
		public abstract Integer deleteMobile(Long mobileId)throws MobilePurchaseException;
		public abstract Mobile getMobileDetails(Long mobileId)throws MobilePurchaseException;
		public abstract Integer updateMobilePrice(Long mobileId,Double newprice) throws MobilePurchaseException;
		public abstract List<Mobile> getAllMobileDetails()throws MobilePurchaseException; 
		
		
}
