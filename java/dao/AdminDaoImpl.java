package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utility.DataConnect;

public class AdminDaoImpl implements AdminDao{

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public boolean adminLogin(String aEmailId, String aPassword) {
		try {
			con = DataConnect.getConnection();
			ps=con.prepareStatement("select * from admin where admin_emailID=? and admin_password=?");
			ps.setString(1, aEmailId);
			ps.setString(2, aPassword);
			
			rs =ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean adminchangepassword(String aEmailId, String aPassword) {
		try {
			con = DataConnect.getConnection();
			ps=con.prepareStatement("update admin set admin_password=? where admin_emailID=?");
			ps.setString(1, aPassword);
			ps.setString(2, aEmailId);
			
			int row = ps.executeUpdate();
			if(row>0) {
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean userLogin(String cEmailId, String cPassword) {
		try {
			con = DataConnect.getConnection();
			ps=con.prepareStatement("select * from customer where customer_emailID=? and customer_password=?");
			ps.setString(1, cEmailId);
			ps.setString(2, cPassword);
			
			rs =ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean userchangepassword(String cEmailId, String cPassword) {
		try {
			con = DataConnect.getConnection();
			ps=con.prepareStatement("update customer set customer_password=? where customer_emailID=?");
			ps.setString(1, cPassword);
			ps.setString(2, cEmailId);
			
			int row = ps.executeUpdate();
			if(row>0) {
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
}
