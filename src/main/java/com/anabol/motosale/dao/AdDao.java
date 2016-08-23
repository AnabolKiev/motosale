package com.anabol.motosale.dao;

import com.anabol.motosale.model.Ad;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
/**
 * Объект доступа к данным об объявлениях. Реализация в памяти.
 */
public class AdDao {
 private Map<Long, Ad> ads = new HashMap<Long, Ad>();
 private AtomicLong sequence = new AtomicLong(1);
 
 // JDBC URL, username and password of MySQL server
 private static final String url = "jdbc:mysql://localhost:3306/ms";
 private static final String user = "root";
 private static final String password = "root";
 
 // JDBC variables for opening and managing connection
 private static Connection con;
 private static Statement stmt;
 private static ResultSet rs;
 
 public AdDao() {
    saveAd(new Ad("Sale sportbike", "Good condition", 1, 1, 2006, 675, 16000, "050 351-92-92", "anabol.ua@gmail.com", new Date(), new Date()));
    saveAd(new Ad("Best cafe-racer", "Very stylish", 1, 1, 2000, 400, 26000, "050 351-92-92", "anabol.ua@gmail.com", new Date(), new Date()));
 }
 
 public List<Ad> getAllAds() {
//	 String query = "select count(*) from ms.ad";
//     try {
//         con = DriverManager.getConnection(url, user, password);
//         stmt = con.createStatement();
//         rs = stmt.executeQuery(query);
//         while (rs.next()) {
//             int count = rs.getInt(1);
//         }
//     } catch (SQLException sqlEx) {
//         sqlEx.printStackTrace();
//     } finally {
//         try { con.close(); } catch(SQLException se) { /*can't do anything */ }
         //         try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
//         try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
//     }	 
 
	 return new ArrayList<Ad>(ads.values());
 }
 
 public Ad findAdById(Long id) {
    return ads.get(id);
 }
 
 public Ad saveAd(Ad ad) {
    if (ad.getId() == null) {
       ad.setId(sequence.getAndIncrement());
    }
    ads.put(ad.getId(), ad);
    return ad;
 }
}
