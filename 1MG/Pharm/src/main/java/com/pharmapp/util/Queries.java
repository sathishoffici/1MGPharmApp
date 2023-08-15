package com.pharmapp.util;

public class Queries {

	public static final String CREATEQUERY = "create table if not exists pharmApp(productName varchar(20),productId integer primary key,price double,type varchar(20),disease varchar(20))";

	public static final String INSERTQUERY = "insert into pharmApp(productName,productId,price,type,disease) values(?,?,?,?,?);";
	public static final String DELETEQUERY = "delete from pharmApp where productName=?;";

	public static final String FINDQUERY = "select * from pharmApp where productName=?;";
	public static final String FINDALL ="select * from pharmApp;";

	public static final String FINDBYDISEASE ="select * from pharmApp where disease=?;";

	public static final String FINDBYTYPE="select * from pharmApp where type=?;";

	public static final String ORDER= "select * from pharmApp ";

}
