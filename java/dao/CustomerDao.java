package dao;

import java.util.List;
import pojo.customer;

public interface CustomerDao {
	
	boolean addCustomer(customer customer);
	boolean updateCustomerById(customer customer);
	boolean deleteCustomerById(String customer_emailID);
	List<customer>getAllCustomer();
	customer searchCustomerById(String customer_emailID);
	
}
