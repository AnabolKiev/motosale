package com.anabol.motosale.dao;

import com.anabol.motosale.model.Ad;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AdDaoJDBC implements AdDao{
	 // JDBC URL, username and password of MySQL server
     private static String url;
	 private static String user;
	 private static String password;
	 Connection connection = null;
     private static Connection con;
     private static AdDaoJDBC instance;
     private static DataSource dataSource;

    public void setUrl(String url) {
        this.url = url;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public static synchronized AdDaoJDBC getInstance() {
        if (instance == null) {
            try {
                instance = new AdDaoJDBC();
                Context ctx = new InitialContext();
                instance.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/AdsDS");
                con = dataSource.getConnection();
            } catch (NamingException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

     public Connection getConnection(){
        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            if(con == null)
//                connection = DriverManager.getConnection(url, user, password);
                con = dataSource.getConnection();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void closeConnection(){
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            //do nothing
        }
    }

    public List<Ad> getAllAds() {
		 List<Ad> ads = new ArrayList<Ad>();
		 	try {
                //connection = getConnection();
                con = getConnection();
		 		Statement statement = con.createStatement();
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
            } finally {
                closeConnection();
            }
		 return ads;
	 }
	 
	 public Ad findAdById(Long id) {
		 Ad ad = null;
		 try {
             //connection = getConnection();
             con = getConnection();
			 PreparedStatement preparedStatement = con.prepareStatement(SQL_FIND_BY_ID);
			 preparedStatement.setLong(1, id);
             ResultSet resultSet = preparedStatement.executeQuery();
             //preparedStatement.close();
		        while (resultSet.next()){
		        	ad = new Ad();
		            ad.setId(resultSet.getLong("id"));
		            ad.setTitle(resultSet.getString("title"));
		        }
		        resultSet.close();
                preparedStatement.close();
		     } catch (SQLException e) {
		    	 e.printStackTrace();
         } finally {
             closeConnection();
         }
		 return ad;
	 }
	 
	 public void insertAd(Ad ad) {
	    try {
            //connection = getConnection();
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1,  ad.getTitle());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeConnection();
        }
	 }

    public void updateAd(Ad ad) {
        try {
            //connection = getConnection();
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1,  ad.getTitle());
            preparedStatement.setLong(2, ad.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void deleteById(Long id) {
        try {
            //connection = getConnection();
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(SQL_DELETE);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

}
