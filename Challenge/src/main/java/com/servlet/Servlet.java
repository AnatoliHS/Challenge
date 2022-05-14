package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.Product;

//Servlet implementation
public class Servlet extends HttpServlet {
private static final long serialVersionUID = 1L;

	ApplicationService products;

	public Servlet() {
		super();
		
		this.products = new ApplicationInMemory();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String action = req.getParameter("action");
		if("delete".equals(action)) {
			delete(req);
		}
		
		String brand = "";
		String productName = "";
		String size = "";
		String id = req.getParameter("id");
		if(id == null || "".equals(id)) {
			//Initialize id
			id = "";
		}else {
			//Read record
			Product product = this.products.readProduct(id);
			if(product == null) {
				// If not found continue render
				id = "";
			}else {
				//Product found
				brand = product.getBrand();
				productName = product.getProductName();
				size = product.getSize();
				
			}
		}
		Map<UUID, Product> products = this.products.readProduct();
		req.setAttribute("id", id);
		req.setAttribute("brand", brand);
		req.setAttribute("productName", productName);
		req.setAttribute("size",  size);
		req.setAttribute("products", products);
		req.getRequestDispatcher("index.jsp").forward(req,res);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
	
		Product product = null;
		String id = req.getParameter("id");
		String brand = req.getParameter("brand");
		String productName = req.getParameter("productName");
		String size = req.getParameter("size");
		
		if(id == null || "".equals(id)) {
			//Create product
			product = new TextRecord(brand, productName, size);
		}else {
			//Read Product
			product = this.products.readProduct(id);
			product.setBrand(brand);
			product.setProductName(productName);
			product.setSize(size);
		}
		//Update Product
		this.products.createOrUpdateProduct(product);
		//Render page with updates
		doGet(req,res);
	}
	
	private void delete(HttpServletRequest req) throws ServletException, IOException{
		String id = req.getParameter("id");
		if(id != null && !id.equals("null")) {
			//Delete Product
			this.products.deleteProduct(id);
		}
	}


}
