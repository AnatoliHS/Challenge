package com.servlet;

import java.util.Map;
import java.util.UUID;

public interface ApplicationService {
	
	public Map<UUID, Product> readProduct();
	
	public Product readProduct(String id);
	
	public void createProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(String id);
	
	public void createOrUpdateProduct(Product product);

}
