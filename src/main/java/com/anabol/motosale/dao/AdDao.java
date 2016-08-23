package com.anabol.motosale.dao;

import com.anabol.motosale.model.Ad;

import java.util.*;
 
public interface AdDao {
 
 public List<Ad> getAllAds();
 public Ad findAdById(Long id);
 public Ad saveAd(Ad ad); 

}
