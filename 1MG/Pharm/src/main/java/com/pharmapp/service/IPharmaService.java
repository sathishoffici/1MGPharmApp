package com.pharmapp.service;

import java.util.List;

import com.pharmapp.exception.ItemNotFoundException;
import com.pharmapp.model.Products;

public interface IPharmaService {
	List<Products> findByDisease(String disease) throws ItemNotFoundException;

	void addItem(Products product);

	void deleteItem(String product);

	Products findByItem(String product);
	
	List<Products> findAll();

	List<Products> findByType(String string) throws ItemNotFoundException;

	String addOrder(List<String> orderItemList);

	

}
