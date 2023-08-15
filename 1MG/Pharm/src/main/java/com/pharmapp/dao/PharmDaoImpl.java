package com.pharmapp.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pharmapp.util.*;
import com.pharmapp.exception.ItemNotFoundException;
import com.pharmapp.model.Products;

public class PharmDaoImpl implements IPharmDao {

	@Override
	public void addItem(Products products) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.INSERTQUERY);) {
			statement.setString(1, products.getProductName());
			statement.setInt(2, products.getProductId());
			statement.setDouble(3, products.getPrice());
			statement.setString(4, products.getType());
			statement.setString(5, products.getDisease());
			statement.execute();
			System.out.println("Item Added");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void deleteItem(String item) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.DELETEQUERY);) {
			statement.setString(1, item);
			statement.execute();
			System.out.println("deleted");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public Products findByItem(String item) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.FINDQUERY);) {
			statement.setString(1, item);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Products products2 = new Products();
				products2.setProductName(resultSet.getString(1));
				products2.setProductId(resultSet.getInt(2));
				products2.setPrice(resultSet.getDouble(3));
				products2.setType(resultSet.getString(4));
				products2.setDisease(resultSet.getString(5));
				

				return products2;

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Products> findAll() {
		List<Products> list = new ArrayList<Products>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.FINDALL);) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Products products2 = new Products();
				products2.setProductName(resultSet.getString(1));
				products2.setProductId(resultSet.getInt(2));
				products2.setPrice(resultSet.getDouble(3));
				products2.setType(resultSet.getString(4));
				products2.setDisease(resultSet.getString(5));
				

				list.add(products2);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return list;

	}

	@Override
	public List<Products> findByDisease(String disease) throws ItemNotFoundException {
		List<Products> list = new ArrayList<Products>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.FINDBYDISEASE);) {
			statement.setString(1, disease);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Products products2 = new Products();
				products2.setProductName(resultSet.getString(1));
				products2.setProductId(resultSet.getInt(2));
				products2.setPrice(resultSet.getDouble(3));
				products2.setType(resultSet.getString(4));
				products2.setDisease(resultSet.getString(5));
				

				list.add(products2);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}



	@Override
	public List<Products> findByType(String string) {
		List<Products> list = new ArrayList<Products>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.FINDBYTYPE);) {
			statement.setString(1, string);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Products products2 = new Products();
				products2.setProductName(resultSet.getString(1));
				products2.setProductId(resultSet.getInt(2));
				products2.setPrice(resultSet.getDouble(3));
				products2.setType(resultSet.getString(4));
				products2.setDisease(resultSet.getString(5));
				

				list.add(products2);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
		
	}

	@Override
	public List<Products> addOrder(List<String> orderItemList) throws ItemNotFoundException {
		
		List<Products> list = new ArrayList<Products>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.ORDER);) {
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Products products2 = new Products();
				products2.setProductName(resultSet.getString(1));
				products2.setProductId(resultSet.getInt(2));
				products2.setPrice(resultSet.getDouble(3));
				products2.setType(resultSet.getString(4));
				products2.setDisease(resultSet.getString(5));
				

				list.add(products2);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

}
