package com.anabol.motosale.dao;

import com.anabol.motosale.model.Ad;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class AdDaoMem implements AdDao{
 private Map<Long, Ad> ads = new HashMap<Long, Ad>();
 private AtomicLong sequence = new AtomicLong(1);
 
 public AdDaoMem() {
    saveAd(new Ad("Sale sportbike", "Good condition", 1, 1, 2006, 675, 16000, "050 351-92-92", "anabol.ua@gmail.com", new Date(), new Date()));
    saveAd(new Ad("Best cafe-racer", "Very stylish", 1, 1, 2000, 400, 26000, "050 351-92-92", "anabol.ua@gmail.com", new Date(), new Date()));
 }
 
 public List<Ad> getAllAds() {
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
