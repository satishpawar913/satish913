package com.demo;

import java.util.Scanner;

import com.domain.Item;
import com.domain.Person;
import com.service.Store;
import com.utils.InputCheckingUtil;


public class ShoppingCartDemo {
	
	public static void main(String[] args) {

		// Variables' declaration
		boolean authenticated = false;
		boolean goMenu = true;
		Person mPerson = null;
		String option;
		
		Store fStore = new com.service.FairfaxStore();
		
		Scanner scan = new Scanner(System.in);
		

		while (!authenticated) {
			// Show menu
			System.out.println("Hi, welcome to our menu :\n   1 - Login Account \n   2 - Create Account ");

			// While the user doesn't enter A or B ask again
			option = " ";
			while (!(option.equals("1") || option.equals("2"))) {
				System.out.println("Enter option : ");
				option = scan.nextLine();
			}

			// Scan username and password
			String username, password;
			System.out.println("Username :");
			username = scan.nextLine();
			System.out.println("Password :");
			password = scan.nextLine();

			// if -> Authenticate or else -> Register
			if (option.equals("1")) {
				mPerson = fStore.authenticatePerson(username, password);
				if (mPerson != null) {
					authenticated = true;
				} else {
					System.out.println("Something went wrong, please restart. \n ");
				}
			} else {
				mPerson = new Person(username, password);
				if (fStore.register(mPerson)) {
					System.out.println(username + " was registered");
				} else {
					System.out
							.println("Something went wrong, please restart. \n ");
				}
			}
		}

		// Variables' Declaration
		String name;
		float price;
		Item item = null;
		long itemId;

		// Once authenticated
		while (goMenu) {

			// Show menu
			System.out.println("\nHi  "+ mPerson.getUsername()
							+ "! \nYour menu :\n   "
							+ "A - Display items in your cart \n  "
							+ "B - Add an item in your cart \n  "
							+ "C - Remove an item from your cart \n  "
							+ "D - Display Items in Store \n   "
							+ "E - Buy Items in Store \n   "
							+ "F - Exit");

			option = " ";

			// While the user don't enter a correct input ask again
			while (!(option.equals("A") || option.equals("B")
					|| option.equals("C") || option.equals("D") || 
					option.equals("E") || option.equals("F"))) {
				System.out.println("Enter option : ");
				option = scan.nextLine();
			}

			// Show cart
			if (option.equals("A")) {
				fStore.showItemsCart(mPerson);
			}
			// Add item to cart
			else if (option.equals("B")) {
				System.out.println("Item ID : ");
				itemId = InputCheckingUtil.getLongWithChecking(scan);

				fStore.addItemToCart(itemId, mPerson);

			}
			// Remove item from cart
			else if (option.equals("C")) {
				System.out.println("Item ID : ");
				itemId = InputCheckingUtil.getLongWithChecking(scan);

				fStore.removeItemFromCart(itemId, mPerson);
			}
			
			// Display items in store
			else if (option.equals("D")) {
				fStore.displayItemsInStore();
			}
			// Buy item from cart
			
			
            else if (option.equals("E")) {
            	
			    System.out.println("Item ID : ");
				itemId = InputCheckingUtil.getLongWithChecking(scan);
				
				fStore.buyProduct(itemId, mPerson);
			}
			
			
			else {
				goMenu = false;
				System.exit(0);
			}

		}

	}

}
