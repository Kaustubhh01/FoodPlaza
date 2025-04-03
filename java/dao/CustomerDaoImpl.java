package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import utility.DataConnect;

import pojo.customer;

public class CustomerDaoImpl implements CustomerDao{

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public boolean addCustomer(customer customer) {
		try {

			con = utility.DataConnect.getConnection();
			ps = con.prepareStatement("insert into customer (customer_name,customer_emailID,customer_password,customer_address,customer_contactNO) values (?,?,?,?,?);");

			ps.setString(1, customer.getCustomer_name());
			ps.setString(2, customer.getCustomer_emailID());
			ps.setString(3, customer.getCustomer_password());
			ps.setString(4, customer.getCustomer_address());
			ps.setLong(5, customer.getCustomer_contactNO());
			
			int row = ps.executeUpdate();

			if(row > 0) {
				return true;
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCustomerById(customer customer) {
try {
			
			con = utility.DataConnect.getConnection();
			ps = con.prepareStatement("update customer set customer_name = ?, customer_password = ?,  customer_address = ?, customer_contactNO = ? where customer_emailID = ?;");
			
			ps.setString(1, customer.getCustomer_name());
			ps.setString(2, customer.getCustomer_password());
			ps.setString(3, customer.getCustomer_address());
			ps.setLong(4, customer.getCustomer_contactNO());
			ps.setString(5, customer.getCustomer_emailID());
			
			int row = ps.executeUpdate();
			
			if(row > 0) {
				return true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCustomerById(String customer_emailID) {
		try {

			con = utility.DataConnect.getConnection();
			ps = con.prepareStatement("delete from customer where customer_emailID = ?;");

			ps.setString(1, customer_emailID);
			int row = ps.executeUpdate();

			if(row>0) {
				return true;
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<customer> getAllCustomer() {
		List<customer> l = new ArrayList<customer>();

		try {

			con = utility.DataConnect.getConnection();
			ps = con.prepareStatement("select * from customer;");
			rs = ps.executeQuery();

			while(rs.next()) {

				customer customer = new customer();

				customer.setCustomer_name(rs.getString("customer_name"));
				customer.setCustomer_emailID(rs.getString("customer_emailID"));
				customer.setCustomer_password(rs.getString("customer_password"));
				customer.setCustomer_address(rs.getString("customer_address"));
				customer.setCustomer_contactNO(rs.getLong("customer_contactNO"));

				l.add(customer);

			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public customer searchCustomerById(String customer_emailID) {
		customer customer = null;
		
		try {
			con = utility.DataConnect.getConnection();
			ps = con.prepareStatement("select * from customer where customer_emailID= ?;");
			
					ps.setString(1, customer_emailID);
					
					rs=ps.executeQuery();
					
					while (rs.next()) {
						customer = new customer();
						customer.setCustomer_emailID(rs.getString("customer_emailID"));
						customer.setCustomer_name(rs.getString("customer_name"));
						customer.setCustomer_password(rs.getString("customer_password"));
						customer.setCustomer_address(rs.getString("customer_address"));
						customer.setCustomer_contactNO(rs.getLong("customer_contactNO"));
					}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

}
