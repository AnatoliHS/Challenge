package com.servlet;

import java.util.Scanner;
import java.util.UUID;

public class Product {
	
	String size;
    String brand;
    String productName;
    UUID id;

     Product(UUID id, String size, String brand, String productName){
    	this.id = UUID.randomUUID();
        this.size = size;
        this.brand = brand;
        this.productName = productName;
       
    }
     
     Product(){
    	 
     }
     
     Product(String brand, String productName, String size){
    	 this.id = UUID.randomUUID();
    	 this.brand = brand;
    	 this.productName = productName;
    	 this.size = size;
    	 }

    public String toString(){
        return "<br>Brand:" + brand + "<br>Product Name:" + productName + "<br>Size: " + size;
    }
    
    public UUID getId() {
    	return id;
    }
    
    public void setId(UUID id) {
    	this.id = id;
    }

    public String getSize(){
        return size;
    }

    public void setSize(String size){
        this.size = size;
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

}
