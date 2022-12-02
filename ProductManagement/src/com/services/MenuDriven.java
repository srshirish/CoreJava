package com.services;

import java.util.List;
import java.util.Scanner;

import com.beans.Product;

public class MenuDriven {

	//Creating object of the class whose methods we want to access as Menu Driven
	ProductServices pservices=new ProductServices();


	//Encapsulating menu execution in the method below
	public void showMenu() {

		int choice=999;	//'999' is a dummy choice to enter into do-while loop.

		do{
			//Write your choices in the following format
			//System.out.println("choice"+". "+"Title of operation to be performed");
			//System.out.println(""+". "+"");
			System.out.println("Enter your choice");
			System.out.println("1"+". "+"Add new product");
			System.out.println("2"+". "+"Remove by ID");
			System.out.println("3"+". "+"Remove by name");
			System.out.println("4"+". "+"Display all product");
			System.out.println("5"+". "+"Find by ID");
			System.out.println("6"+". "+"Find by name");
			System.out.println("7"+". "+"Sort by quantity");
			System.out.println("8"+". "+"Sort by name");
			System.out.println("9"+". "+"Modify price");
			System.out.println("10"+". "+"Exit");


			Scanner sc=new Scanner(System.in);
			choice=sc.nextInt();
			switch (choice) {

			case 1:
				pservices.addNewProduct();
				break;

			case 2:
				System.out.println("Enter the product ID to remove");
				int pidr=sc.nextInt();
				boolean statusRI=pservices.removeByID(pidr);
				if(statusRI)
					System.out.println("Product removed successfully...");
				break;
				
			case 3:
				System.out.println("Enter the product Name to remove");
				String pnamer=sc.next();
				boolean statusRN=pservices.removeByName(pnamer);
				if(statusRN)
					System.out.println("Product removed successfully...");
				break;

			case 4:
				List<Product> lfound=pservices.displayAllProduct();
				System.out.println(lfound);
				break;

			case 5:
				System.out.println("Enter the product ID to search");
				int pids=sc.nextInt();
				Product pfoundI=pservices.findByID(pids);
				if(pfoundI!=null)
					System.out.println("Product you were looking for..."+pfoundI);
				else
					System.err.println("Product not found...!!!");
				break;
			
			case 6:
				System.out.println("Enter the product Name to search");
				String pnames=sc.next();
				Product pfoundN=pservices.findByName(pnames);
				if(pfoundN!=null)
					System.out.println("Product you were looking for..."+pfoundN);
				else
					System.err.println("Product not found...!!!");
				break;
				
			case 7:
				boolean statusQ=pservices.sortByQuantity();
				if(statusQ)
					System.out.println("Sorted the list by Quantity");
				else
					System.err.println("Nothing to sort, list is empty...!!!");
				break;
				
			case 8:
				boolean statusN=pservices.sortByName();
				if(statusN)
					System.out.println("Sorted the list by Name");
				else
					System.err.println("Nothing to sort, list is empty...!!!");
				break;

			case 9:
				System.out.println("Enter the product ID to modify price");
				int pidm=sc.nextInt();
				System.out.println("Enter the new price");
				double price=sc.nextDouble();
				boolean statusM=pservices.modifyPrice(pidm,price);
				if(statusM)
					System.out.println("Price modified successfully...");
				break;

			case 10:	
				System.out.println("Thankyou for using...");
				break;

			default:
				System.err.println("Invalid Option");
			}
		}while(choice!=10);
	}
}

