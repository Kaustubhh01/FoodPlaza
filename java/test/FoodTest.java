package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.FoodDaoImpl;
import pojo.food;

public class FoodTest {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int food_ID, food_quantity; String food_name, food_type; float food_price;



		FoodDaoImpl foodobj = new FoodDaoImpl();
		List<food> l = new ArrayList<>();

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

				for(int i = 1; i <= num; i++)
				{
					System.out.print("Enter the food name: ");
					food_name = br.readLine();

					System.out.print("\nEnter the food type: ");
					food_type = br.readLine();

					System.out.print("\nEnter the food quantity: ");
					food_quantity = sc.nextInt();

					System.out.print("\nEnter the food price: ");          
					float price = sc.nextFloat();
					food_price = food_quantity * price;

					b = foodobj.addFood(new food(food_name,food_type,food_quantity,food_price));

					if(b) {
						System.out.println("\n"+ food_name + " added successfully.\n");
					}
					else {
						System.out.println("\nFailed to add.");
					}

				}

				break;

			case 2 : 

				System.out.print("\nEnter the food id: ");
				food_ID = sc.nextInt();
				
				System.out.print("\nEnter the food name: ");
				food_name = br.readLine();

				System.out.print("\nEnter the food type: ");
				food_type = br.readLine();

				System.out.print("\nEnter the food quantity: ");
				food_quantity = sc.nextInt();

				System.out.print("\nEnter the food price: ");          
				float price = sc.nextFloat();
				food_price = food_quantity * price;

				food foodUpdate = new food(food_name,food_type,food_quantity,food_price);
				foodUpdate.setFood_ID(food_ID); 
				b = foodobj.updateFoodById(foodUpdate);

				if(b) {
					System.out.println(food_name + " updated successfully.");
				}
				else {
					System.out.println("Failed to update.");
				}  

				break;

			case 3 : 

				System.out.print("\nEnter the food id: ");
				food_ID = sc.nextInt();
				System.out.println();

				b = foodobj.deleteFoodById(food_ID);

				if(b) {
					System.out.print("\nID " + food_ID + " deleted successfully.");
				}
				else {
					System.out.println("Failed to delete or there is no such data.");
				}

				break;


			case 4 : 

				System.out.print("Enter the Food ID for search: ");
				food_ID = sc.nextInt();
				System.out.println();

				food food = new food();
				food = foodobj.searchFoodById(food_ID);

				if(food != null) {

					System.out.println(food);

				}

				else {

					System.out.println("Item Not Available");

				}

				break;

			case 5 :
				
				System.out.println("Showing all menu: ");
				
				l = foodobj.getAllFood();
				
				Iterator<food> fi = l.iterator();
				
				while(fi.hasNext()) {
					System.out.println(fi.next());
				}

				break;
				
			default :
				
				System.out.println("You entered something wrong!!!");
				
				break;

			}



		}

	}

}