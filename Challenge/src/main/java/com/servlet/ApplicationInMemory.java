package com.servlet;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class ApplicationInMemory implements ApplicationService{
	
	private Map<UUID, Product> products;
	
	public ApplicationInMemory() {
		this.products = new LinkedHashMap<UUID, Product>();
	}

	@Override
	public Map<UUID, Product> readProduct() {
		// TODO Auto-generated method stub
		return products;
	}

	@Override
	public Product readProduct(String id) {
		// TODO Auto-generated method stub
		return products.get(UUID.fromString(id));
	}

	@Override
	public void createProduct(Product product) {
		// TODO Auto-generated method stub
		updateProduct(product);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		products.put(product.getId(), product);
	}

	@Override
	public void deleteProduct(String id) {
		// TODO Auto-generated method stub
		products.remove(UUID.fromString(id));
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
