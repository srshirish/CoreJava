package com.services;

import java.util.Comparator;

import com.beans.Product;

public class SortByName implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		if(o1.getPname().equals(o2.getPname()))
			return o1.getPid()-o2.getPid();
		else
			return o1.getPname().compareTo(o2.getPname());
	}
	
}
