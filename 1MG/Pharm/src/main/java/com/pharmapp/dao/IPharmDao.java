package com.pharmapp.dao;

import java.util.List;

import com.pharmapp.exception.ItemNotFoundException;
import com.pharmapp.model.Products;

public interface IPharmDao {

	void addItem(Products products);

	void deleteItem(String item);

	Products findByItem(String item);

	List<Products> findAll();

	List<Products> findByDisease(String disease) throws ItemNotFoundException;

	List<Products> addOrder(List<String> orderItemList) throws ItemNotFoundException;

	List<Products> findByType(String string) throws ItemNotFoundException;

	

}
