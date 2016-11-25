package com.niit.pattern.dao;

import java.util.List;

import com.niit.pattern.entity.Product;

public interface ProductDAO{
	Product get(int id);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	List<Product> getByCategory(String category);
}

