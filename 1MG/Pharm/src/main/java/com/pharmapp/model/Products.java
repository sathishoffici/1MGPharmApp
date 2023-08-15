package com.pharmapp.model;

public class Products {

	private String productName;
	private Integer productId;
	private double price;
	private String type;
	private String disease;

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(String productName, Integer productId, double price, String type, String disease) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.price = price;
		this.type = type;
		this.disease = disease;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	@Override
	public String toString() {
		return "Products [productName=" + productName + ", productId=" + productId + ", price=" + price + ", type="
				+ type + ", disease=" + disease + "]";
	}

}
