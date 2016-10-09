package com.anabol.motosale.dao;

import com.anabol.motosale.model.Ad;
import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.springframework.stereotype.Repository;

@Repository(value = "adDao")
public class AdDaoJNDI implements AdDao{
     private static Connection con;
     private static AdDaoJNDI instance = getInstance();
     private static DataSource dataSource;

     private AdDaoJNDI () {
    }

      public static synchronized AdDaoJNDI getInstance() {
        if (instance == null) {
            try {
                instance = new AdDaoJNDI();
                Context ctx = new InitialContext();
                instance.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/AdsDS");
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return instance;
     }

     public Connection getConnection(){
        try {
//            if(con == null)
                con = dataSource.getConnection();
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
             con = getConnection();
			 PreparedStatement preparedStatement = con.prepareStatement(SQL_FIND_BY_ID);
			 preparedStatement.setLong(1, id);
             ResultSet resultSet = preparedStatement.executeQuery();
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
