package com.anabol.motosale.dao;

import com.anabol.motosale.model.Ad;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class AdDaoJDBC implements AdDao{
	 private AtomicLong sequence = new AtomicLong(1);
	 // JDBC URL, username and password of MySQL server
	 private static final String url = "jdbc:mysql://localhost:3306/ms";
	 private static final String user = "root";
	 private static final String password = "root";
	 
	 // JDBC variables for opening and managing connection
	 //private static Connection con;
	 //private static Statement stmt;
	 //private static ResultSet rs;
	 Connection connection = null;
	 
     public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if(connection == null)
                connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
	    
//	 public AdDaoJDBC() {
//	    saveAd(new Ad("Sale sportbike", "Good condition", 1, 1, 2006, 675, 16000, "050 351-92-92", "anabol.ua@gmail.com", new Date(), new Date()));
//	    saveAd(new Ad("Best cafe-racer", "Very stylish", 1, 1, 2000, 400, 26000, "050 351-92-92", "anabol.ua@gmail.com", new Date(), new Date()));
//	 }
	 
	 public List<Ad> getAllAds() {
		 List<Ad> ads = new ArrayList<Ad>();
		 	try {
		 		Statement statement = connection.createStatement();
		        ResultSet resultSet = statement.executeQuery("SELECT * FROM ms.ad");
		        Ad ad = null;
		        while(resultSet.next()){
		        	ad = new Ad();
		            ad.setId(Long.parseLong(resultSet.getString("id")));
		            ad.setTitle(resultSet.getString("title")); 
		            ads.add(ad);
		        }
		        resultSet.close();
		        statement.close();
		     } catch (SQLException e) {
		    	 e.printStackTrace();
		     } 	 
		 return ads;
	 }
	 
	 public Ad findAdById(Long id) {
		 Ad ad = null;
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ms.ad WHERE id = ?");
			 preparedStatement.setLong(1, id);
             ResultSet resultSet = preparedStatement.executeQuery();
             preparedStatement.close();
		        if (resultSet.first()){
		        	ad = new Ad();
		            ad.setId(Long.parseLong(resultSet.getString("id")));
		            ad.setTitle(resultSet.getString("title")); 
		        }
		        resultSet.close();
		     } catch (SQLException e) {
		    	 e.printStackTrace();
		     }
		 return ad;
	 }
	 
	 public Ad saveAd(Ad ad) {
	    if (ad.getId() == null) {
	       ad.setId(sequence.getAndIncrement());
	    }
	    try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ms.ad (id ,title) VALUES (? , ?)");
            preparedStatement.setLong(1, ad.getId());
            preparedStatement.setString(2,  ad.getTitle());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    return ad;
	 }
	 
	 public void closeConnection(){
		 try {
			 if (connection != null) {
	             connection.close();
	         }
	     } catch (Exception e) { 
	            //do nothing
	     }
	 }
}
