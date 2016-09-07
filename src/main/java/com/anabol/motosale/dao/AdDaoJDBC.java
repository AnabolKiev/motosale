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

    public void closeConnection(){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            //do nothing
        }
    }

    public List<Ad> getAllAds() {
		 List<Ad> ads = new ArrayList<Ad>();
		 	try {
		 		Statement statement = connection.createStatement();
		        ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL);
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
			 PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID);
			 preparedStatement.setLong(1, id);
             ResultSet resultSet = preparedStatement.executeQuery();
             //preparedStatement.close();
		        while (resultSet.next()){
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
	 
	 public void insertAd(Ad ad) {
         if (ad.getId() == null) {
             ad.setId(sequence.getAndIncrement());
         }
	    try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setLong(1, ad.getId());
            preparedStatement.setString(2,  ad.getTitle());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	 }

    public void updateAd(Ad ad) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1,  ad.getTitle());
            preparedStatement.setLong(2, ad.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void deleteById(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
