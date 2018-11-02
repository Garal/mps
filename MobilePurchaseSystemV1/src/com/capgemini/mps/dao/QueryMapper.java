package com.capgemini.mps.dao;

public interface QueryMapper {

	public static final String INSERT_MOBILE="INSERT INTO mobile(name,price,quantity) VALUES(?,?,?)";
	public static final String DELETE_MOBILE="DELETE FROM mobile WHERE mobile_id=?";
	public static final String SELECT_MOBILE="SELECT * FROM mobile WHERE mobile_id=?";
	public static final String SELECT_ALL_MOBILE="SELECT * FROM mobile ";
	
	
	
}
