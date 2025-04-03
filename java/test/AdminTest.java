package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import dao.AdminDaoImpl;
import dao.CustomerDaoImpl;

public class AdminTest {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner (System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String admin_emailID,admin_password,customer_emailID,customer_password;

		AdminDaoImpl adminobj = new AdminDaoImpl();

		while(true) {

			System.out.println("\n1.AdminLogin \n2.UpdateAdminpassword \n3.UserLogin \n4.UpdateUserpassword \n5.Exit");

			System.out.print("\nEnter the choice: ");
			int choice = sc.nextInt();
			//			System.out.println();

			boolean b;

			switch(choice) { 

			case 1 :
				System.out.println("Enter Admin email id :");
				admin_emailID = br.readLine();

				System.out.println("Enter Admin password :");
				admin_password = br.readLine();

				b = adminobj.adminLogin(admin_emailID, admin_password);

				if(b) {
					System.out.println("successfully Login");
				}
				else {
					System.out.println("failed to login");
				}
				break;
				
			case 2 :
				
				System.out.println("Enter Admin password :");
				admin_password = br.readLine();
				
				System.out.println("Enter admin email id :");
				admin_emailID = br.readLine();
				
				b = adminobj.adminchangepassword(admin_emailID,admin_password );

				if(b) {
					System.out.println("successfully updated");
				}
				else {
					System.out.println("failed to update");
				}
				break;
				
			case 3 :
				System.out.println("Enter customer email id :");
				customer_emailID = br.readLine();

				System.out.println("Enter Admin password :");
				customer_password = br.readLine();

				b = adminobj.userLogin(customer_emailID, customer_password);

				if(b) {
					System.out.println("successfully Login");
				}
				else {
					System.out.println("failed to login");
				}
				break;
				
			case 4 :
				
				System.out.println("Enter customer password :");
				customer_password = br.readLine();
				
				System.out.println("Enter customer email id :");
				customer_emailID = br.readLine();

				b = adminobj.userchangepassword(customer_emailID,customer_password );

				if(b) {
					System.out.println("successfully updated");
				}
				else {
					System.out.println("failed to update");
				}
				break;
			}
		}
	}
}
