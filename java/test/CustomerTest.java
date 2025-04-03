package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.CustomerDaoImpl;
import pojo.customer;

public class CustomerTest {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String customer_name, customer_emailID, customer_password, customer_address;
		long customer_contactNO;

		CustomerDaoImpl customerobj = new CustomerDaoImpl();
		List<customer> l = new ArrayList<>();

		while(true) {

			System.out.println("\n1.Add\n2.Update\n3.Delete\n4.Search\n5.ShowAllData");

			System.out.print("\nEnter the choice: ");
			int choice = sc.nextInt();
			System.out.println();

			boolean b;

			switch(choice) {

			case 1 :

				System.out.print("How many data you want to add: ");
				int num = sc.nextInt();
				System.out.println();

				for(int i = 1; i <= num; i++) {

					System.out.print("\nEnter Customer Name: ");
					customer_name = br.readLine();

					System.out.print("\nEnter Customer E-mail ID: ");
					customer_emailID = br.readLine();

					System.out.print("\nEnter Customer Password: ");
					customer_password = br.readLine();

					System.out.print("\nEnter Customer Address: ");
					customer_address = br.readLine();

					System.out.print("\nEnter Customer ContactNo.: ");
					customer_contactNO = sc.nextLong();

					b = customerobj.addCustomer(new customer(customer_name,customer_emailID,customer_password,customer_address,customer_contactNO));

					if(b) {
						System.out.println("\n" + customer_name + " added successfully.");
					}
					else {
						System.out.println("\nFailed to add.");
					}
				}

				break;

			case 2 :

				System.out.println();
				System.out.print("\nEnter Customer Name: ");
				customer_name = br.readLine();

				System.out.print("\nEnter Customer E-mail ID: ");
				customer_emailID = br.readLine();

				System.out.print("\nEnter Customer Password: ");
				customer_password = br.readLine();

				System.out.print("\nEnter Customer Address: ");
				customer_address = br.readLine();

				System.out.print("\nEnter Customer ContactNo.: ");
				customer_contactNO = sc.nextLong();

				customer c = new customer(customer_name,customer_emailID,customer_password,customer_address,customer_contactNO);
				c.setCustomer_emailID(customer_emailID);
				b = customerobj.updateCustomerById(c);

				if(b) {
					System.out.println("Updated Successfully");
				}
				else {
					System.out.println("Failed to Update");
				}
			
			break;
			
			case 3 : 

				System.out.print("\nEnter the customer emaailID: ");
				customer_emailID = br.readLine();
				System.out.println();

				b = customerobj.deleteCustomerById(customer_emailID);

				if(b) {
					System.out.print("\nID " + customer_emailID + " deleted successfully.");
				}
				else {
					System.out.println("Failed to delete or there is no such data.");
				}
		
				break;


			case 4 : 

				System.out.print("Enter the customer emailID for search: ");
				customer_emailID = br.readLine();
				System.out.println();

				customer customer = new customer();
				customer = customerobj.searchCustomerById(customer_emailID);

				if(customer != null) {

					System.out.println(customer);

				}

				else {

					System.out.println("Item Not Available");

				}

				break;

			case 5 :
				
				System.out.println("Showing all customers: ");
				
				l = customerobj.getAllCustomer();
				
				Iterator<customer> ci = l.iterator();
				
				while(ci.hasNext()) {
					System.out.println(ci.next());
				}

				break;
				
			default :
				
				System.out.println("You entered something wrong!!!");
				
				break;

			}



		}

	}

}