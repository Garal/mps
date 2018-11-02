package com.capgemini.mps.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.mps.dto.Mobile;
import com.capgemini.mps.exception.MobilePurchaseException;
import com.capgemini.mps.utility.DBConnection;
import com.capgemini.mps.utility.MySQLConnection;

public class MobileDaoImpl implements IMobileDAO {

	@Override
	public Integer addNewMobile(Mobile mobile) throws MobilePurchaseException {
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		try {
			connection=MySQLConnection.getConnection();
			preparedStatement=
					connection.prepareStatement(QueryMapper.INSERT_MOBILE);
			//preparedStatement.setLong(1, mobile.getMobileId());
			preparedStatement.setString(1, mobile.getName());
			preparedStatement.setDouble(2, mobile.getPrice());
			preparedStatement.setInt(3, mobile.getQuantity());
			int n=preparedStatement.executeUpdate();
			return n;
			
		}catch(SQLException e){
			//e.printStackTracer();
			//TODO: Log to file
			throw new MobilePurchaseException("Unable to add new mobile"+e.getMessage());
		}catch(Exception e){
			//TODO: Log to file
			throw new MobilePurchaseException("Unable to add new mobile"+e.getMessage());
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Integer deleteMobile(Long mobileId) throws MobilePurchaseException {
		try (
			Connection connection=
					MySQLConnection.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(QueryMapper.DELETE_MOBILE);
		)
		 {
			preparedStatement.setLong(1,mobileId);
			int n=preparedStatement.executeUpdate();
			return n;
			
		}catch(SQLException e){
			throw new MobilePurchaseException("Unable to delete ");
		}catch(IOException e){
			throw new MobilePurchaseException(e.getMessage());
		}
		
		
	}
	

	@Override
	public Mobile getMobileDetails(Long mobileId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mobile> getAllMobileDetails() throws MobilePurchaseException {
		try (
			Connection connection = MySQLConnection.getConnection();
			Statement statement = connection.createStatement();
			)
			{
			ResultSet resultSet=statement.executeQuery(QueryMapper.SELECT_ALL_MOBILE);
			List<Mobile> mobileList=new ArrayList<>();
			while(resultSet.next())
			{
				    Mobile mobile = new Mobile();
		            populateMobile(resultSet, mobile);
		            mobileList.add(mobile);
			}
			return mobileList;
			}
		catch(SQLException e)
        {
            e.printStackTrace();
            throw new MobilePurchaseException(e.getMessage());
        }
        catch(IOException e)
        {
            e.printStackTrace();
            throw new MobilePurchaseException(e.getMessage());
        }
		
	}

	private void populateMobile(ResultSet resultSet, Mobile mobile)
			throws SQLException {
		mobile.setMobileId(resultSet.getLong("mobile_id"));
		mobile.setName(resultSet.getString("name"));
		mobile.setPrice(resultSet.getDouble("price"));
		mobile.setQuantity(resultSet.getInt("Quantity"));
	}

	@Override
	public Integer updateMobilePrice(Long mobileId, Double newprice)
			throws MobilePurchaseException {
		
		return null;
	}

}
