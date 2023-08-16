package com.pharmapp.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.pharmapp.exception.ItemNotFoundException;
import com.pharmapp.model.Products;
import com.pharmapp.service.IPharmaService;
import com.pharmapp.service.PharmaServiceImpl;
import com.pharmapp.util.DbConnection;

public class PharmMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		DbConnection.openConnection();
		// adding data
		Products product = new Products("Dolo650", 1, 20, "Tablet", "Fever");
		Products products1 = new Products("Cold", 2, 30, "Syrup", "Cold");
		Products products2 = new Products("Pan-40", 3, 40, "Tablet", "Pain");
		Products products3 = new Products("Odomos", 4, 50, "Ointment", "Rashes");

		IPharmaService iPharmaService = new PharmaServiceImpl();
//		iPharmaService.addItem(product);
//		iPharmaService.addItem(products1);
//		iPharmaService.addItem(products3);
//		iPharmaService.addItem(products3);

		System.out.println("Welcome To 1MG");

		System.out.println("1.ADMIN LOGIN	\n" + "2.USER LOGIN \n");
		int log = scanner.nextInt();
		if (log == 1) {
			System.out.println("Enter Your Choice \n" + "1.ADD ITEM \n+" + "2.DELETE ITEM\n");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Product Details ");

				break;
			case 2:
				System.out.println("Enter Product Name:");
				String deleteString = scanner.next();
				iPharmaService.deleteItem(deleteString);

			default:
				break;
			}
		} else if (log == 2) {
			System.out.println("	1.Find an Item by name \n" + "	2.Find an item by Catagory \n" + "	3.Show All Item\n"
					+"	4.Find by disease\n" + "	5.Place an Order");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Product Name ");
				String find = scanner.next();
				iPharmaService.findByItem(find);

				break;
			case 2:
				System.out.println("Enter Catagory:");
				String catagString = scanner.next();
				iPharmaService.findByType(catagString).forEach(System.out::println);;
				break;
			case 3:
				System.out.println("The Items Are\n");
				iPharmaService.findAll().forEach(System.out::println);;
				break;
			case 4:
				System.out.println("Enter the Disease Name");
				iPharmaService.findByDisease("cough").forEach(System.out::println);
				

			case 5:
				System.out.println("Enter Product Names to add to cart");
				List<String> orderItemList = new ArrayList<>();

				for (int i = 0; i < 3; i++) {
					orderItemList.add(scanner.next());
				}
				System.out.println(iPharmaService.addOrder(orderItemList));
				

			default:
				
				break;
			}

		} else {
			System.out.println("Wrong input!!");
		}

	
	}
}
