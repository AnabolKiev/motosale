package com.anabol.motosale.dao;

import com.anabol.motosale.model.Ad;

import java.util.*;
 
public interface AdDao {
 public static final String SQL_FIND_ALL = "select * from ms.ad";
 public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " where id = ?";
 public static final String SQL_INSERT = "insert into ms.ad (id, title) values (?, ?)";
 public static final String SQL_UPDATE = "update ms.ad set title = ? where id = ?";
 public static final String SQL_DELETE = "delete from ms.ad where id = ?";
 
 public List<Ad> getAllAds();
 public Ad findAdById(Long id);
 public void insertAd(Ad ad);
 public void updateAd(Ad ad);
 public void deleteById(Long id);
}
