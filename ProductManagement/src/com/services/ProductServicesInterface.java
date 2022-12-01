package com.services;

import java.util.List;

import com.beans.Product;

public interface ProductServicesInterface {
	
	public void addNewProduct();
	
	public List<Product> displayAllProduct();
	
	public Product findByID(int pid);
	
	public Product findByName(String pname);
	
	public boolean removeByID(int pid);
	
	public boolean removeByName(String pnamer);
	
	public boolean modifyPrice(int pid,double price);

}
