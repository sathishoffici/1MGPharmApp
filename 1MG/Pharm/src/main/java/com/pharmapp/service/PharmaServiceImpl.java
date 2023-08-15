package com.pharmapp.service;

import java.util.ArrayList;
import java.util.List;

import com.pharmapp.dao.IPharmDao;
import com.pharmapp.dao.PharmDaoImpl;
import com.pharmapp.exception.ItemNotFoundException;
import com.pharmapp.model.Products;

public class PharmaServiceImpl implements IPharmaService {
	IPharmDao iPharmDao = new PharmDaoImpl();

	@Override
	public void addItem(Products product) {
		iPharmDao.addItem(product);

	}

	@Override
	public void deleteItem(String product) {
		iPharmDao.deleteItem(product);

	}

	@Override
	public Products findByItem(String product) {
		Products products = iPharmDao.findByItem(product);
		System.out.println(products);
		return products;
	}

	@Override
	public List<Products> findAll() {
		return iPharmDao.findAll();
	}

	@Override
	public List<Products> findByDisease(String disease) throws ItemNotFoundException {

		return iPharmDao.findByDisease(disease);
	}

	@Override
	public List<Products> findByType(String string) throws ItemNotFoundException {
		return iPharmDao.findByType(string);
	}

	@Override
	public String addOrder(List<String> orderItemList) {
		String result = "			<--Bill->\n";
		Double priceDouble = 0.00;
		List<Products> list = new ArrayList<>();
		for (String ord : orderItemList) {
			list.add(iPharmDao.findByItem(ord));

		}
		
		for (Products products : list) {
			priceDouble = priceDouble + products.getPrice();
			result += "Product Name :" + products.getProductName() + " Price: " + products.getPrice() + "\n";

		}

		return result + "Total Price " + priceDouble;

	}

}
