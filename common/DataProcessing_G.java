//package common;
//
//import java.sql.*;
//
//
//
//public class DataProcessing_G {
//
//	Connection connection;
//	Statement statement;
//	ResultSet resultSet;
//	String driverName = "com.mysql.jdbc.Driver";
//	String url = "root";
//	String user = "root";
//	String password = "5367";
//	try{
//		Class.forName(driverName);
//		connection = DriverManager.getConnection(url, user, password);
//		statement = connection.createStatement();
//	} catch(ClassNotFoundException e ){
//    	System.out.println("������������");
//    } catch(SQLException e){
//    	System.out.println("���ݿ����");
//    	//e.printStackTrace();
//    }
//	
//	
//	
//}
