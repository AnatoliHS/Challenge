package com.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class ApplicationDao implements ApplicationService{

	@Override
	public Map<UUID, Product> readProduct() {
		
		Product product =  null;
		Map<UUID, Product> products = new LinkedHashMap<UUID, Product>();
		
		// Getting connection to DB
		
		try {
			Connection connection = DBConnection.getConnectionToDatabase();
			
			// Select statement to fetch all product
			String sql = "select * from products;";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			//execute and get result set
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				product = new TextRecord();
				product.setId(UUID.fromString(set.getString("uuid")));
				product.setBrand(set.getString("make"));
				product.setProductName(set.getString("name"));
				product.setSize(set.getString("year"));
				
				products.put(product.getId(), product);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}

	@Override
	public Product readProduct(String id) {
		
		Product product =  null;
		
		// get connection to DB
		try {
			Connection connection = DBConnection.getConnectionToDatabase();
			
			//Select statement to get product
			String sql = "select * from products;";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				product = new TextRecord();
				product.setId(UUID.fromString(set.getString("uuid")));
				product.setBrand(set.getString("brand"));
				product.setProductName(set.getString("productName"));
				product.setSize(set.getString("size"));
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return product;
	}

	@Override
	public void createProduct(Product product) {
		
			// Get connection to DB
		try {
			Connection connection = DBConnection.getConnectionToDatabase();
			//Select statement to get product
			String sql = "insert into products (uuid, brand, productName, size) values (?, ?, ?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1,  product.getId().toString());
			statement.setString(2,  product.getBrand());
			statement.setString(3,  product.getProductName());
			statement.setString(4,  product.getSize());
			
			statement.execute();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateProduct(Product product) {
		
		// Get connection to DB
		try {
			Connection connection = DBConnection.getConnectionToDatabase();
			
			// Select statement to get product
			String sql = "update products set brand=?, productName=?, size=? where uuid=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			//statement.setString(1,  car.getId().toString());
			statement.setString(1,  product.getBrand());
			statement.setString(2,  product.getProductName());
			statement.setString(3,  product.getSize());
			
			statement.execute();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteProduct(String id) {
		
		// Get connection to DB
		try {
			Connection connection = DBConnection.getConnectionToDatabase();
			
			//Select statement to get product
			String sql = "delete from products where uuid=?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,  UUID.fromString(id).toString());
			
			statement.execute();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void createOrUpdateProduct(Product product) {
		// TODO Auto-generated method stub
		Product localProduct = readProduct(product.getId().toString());
		if(localProduct == null) {
			createProduct(product);
		}else {
			updateProduct(product);
		}
		
	}

}
