package com.beans;

public class Product implements Comparable<Product> {
	
	//Data members for "Product" class
	private int pid;
	private String pname;
	private int qty;
	private double price;
	
	//Default constructor
	public Product() {
		this(0,null,0,0.00);
	}
	
	//Parameterized constructor
	public Product(int pid, String pname, int qty, double price) {
		this.pid = pid;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
	}
	
	//Constructor for findByID method in ProductServices
	public Product(int pid) {
		this(pid,null,0,0);
	}
	
	//equals method for indexOf method using inside findByID
	public boolean equals(Object obj) {
		if(this.pid==((Product)obj).getPid())
			return true;
		else
			return false;
	}

	//getters methods
	public int getPid() {return pid;}
	public String getPname() {return pname;}
	public int getQty() {return qty;}
	public double getPrice() {return price;}

	//setter methods 
	public void setPid(int pid) {this.pid = pid;}
	public void setPname(String pname) {this.pname = pname;}
	public void setQty(int qty) {this.qty = qty;}
	public void setPrice(double price) {this.price = price;}

	//toString method
	@Override
	public String toString() {
		return "\n"+"Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", price=" + price + "]";
	}

	//Compare method, implementation of a method from Comparable<Product> interface.
	@Override
	public int compareTo(Product o) {
		if(o.getQty()<this.qty)
			return 1;
		else if(o.getQty()==this.qty)
			return 0;
		else
			return -1;
	}
}