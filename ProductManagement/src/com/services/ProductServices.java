package com.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.beans.*;

public class ProductServices implements ProductServicesInterface {

	//As mentioned below, both of the statement are static so as soon as default constructor will get called
	//we will have a initialized ArrayList wherever we will make its object.

	static List<Product> plist;	//Choosing static ArrayList as Product's objects will be sharing same space. 
	static {
		plist=new ArrayList<>(10);	//Creating ArrayList for storing 10 Product's class objects.
		//Initializing the list with some products.
		plist.add(new Product(1,"ParleG",55,65.55));
		plist.add(new Product(3,"Maggie",56,54.56));
		plist.add(new Product(2,"Daal",96,120.65));
	}
	Scanner sc=new Scanner(System.in);

	public void addNewProduct() {
		System.out.println("Enter the product ID");
		int pid=sc.nextInt();
		System.out.println("Enter the product Name");
		String pname=sc.next();
		System.out.println("Enter the product Quantity");
		int qty=sc.nextInt();
		System.out.println("Enter the product Price");
		double price=sc.nextDouble();
		Product p=new Product(pid,pname,qty,price);
		plist.add(p);
	}

	public List<Product> displayAllProduct() {
		if(plist.size()>0)
			return plist;
		else
			return null;
	}

	public Product findByID(int pid) {
		Product psearch=new Product(pid);
		int status=plist.indexOf(psearch);
		if(status!=-1) 
			return plist.get(status);
		else
			return null;
	}

	public boolean removeByID(int pid) {
		Product pfound=findByID(pid);
		if(pfound==null) {
			System.err.println("Product not found...!!!");
			return false;
		}
		plist.remove(pfound);
		return true;
	}

	public boolean modifyPrice(int pid,double price) {
		Product pfound=findByID(pid);
		if(pfound==null) {
			System.err.println("Product not found...!!!");
			return false;
		}
		pfound.setPrice(price);
		return true;		
	}

	public Product findByName(String pname) {
		for(Product p:plist) {
			if(p.getPname().equals(pname))	//This .equals() belongs to the normal string class.
				return p;
		}
		return null;
	}

	public boolean removeByName(String pnamer) {
		Product pfound=findByName(pnamer);
		if(pfound==null) {
			System.err.println("Product not found...!!!");
			return false;
		}
		plist.remove(pfound);
		return true;
	}
	
	
}
