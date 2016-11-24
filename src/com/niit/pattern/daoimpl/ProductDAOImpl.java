package com.niit.pattern.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.niit.pattern.dao.ProductDAO;
import com.niit.pattern.entity.Product;

public class ProductDAOImpl implements ProductDAO{

	//Singleton Pattern
	private static ProductDAO productDAO = null;
	
	public static ProductDAO getProductDAO(){
		if(productDAO== null){
			productDAO = new ProductDAOImpl();
		}
		return productDAO;
	}
	List<Product> products = null;
	List<Product> tempList = null;
	private ProductDAOImpl(){
	products = new ArrayList<>();
	products.add(new Product(1,"Galaxy Note 3", "Samsung", "Mobile", "This is a Mobile", 18000, 3));
	products.add(new Product(2,"Micromax Canvas", "Micromax", "Phone", "This is a Mobile", 10000,4));
	products.add(new Product(3,"Iphone6s", "Apple", "Mobile", "This is a Mobile", 12100, 6));
	products.add(new Product(4,"Mi Note 3", "Xioami", "Mobile", "This is a Mobile", 16000, 8));
	products.add(new Product(5,"Moto G3", "Motorola", "Mobile", "This is a Mobile", 20000, 10));
	}
	@Override
	public Product get(int id) {
		for (Product product : products) {
			if(product.getId() == id){
				return product;
			}
		}
		return null;
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return products;
	}

	@Override
	public boolean add(Product product) {
		products.add(product);
		return true;
	}

	@Override
	public boolean update(Product product) {
		Product original = null;
		for (Product temp : products) {
			if(temp.getId() == product.getId()) {
				original = temp;
				break;
			}
		}
		
		// transfer the updated value
		original.setName(product.getName());
		return true;
	}

	@Override
	public boolean delete(Product product) {
		products.remove(product);
		return true;
	}

	@Override
	public List<Product> catList() {
		return tempList;
	}
	@Override
	public Product getCat(String cat) {
		tempList = new ArrayList<>();
		for (Product product : products) {
			if(product.getCategory().equals(cat)){
				tempList.add(product);
				
			}
		}
		return null;
	}
	
}
