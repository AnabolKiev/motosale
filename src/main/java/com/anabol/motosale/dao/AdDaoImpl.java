package com.anabol.motosale.dao;

import com.anabol.motosale.dao.repository.AdRepository;
import com.anabol.motosale.model.Ad;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdDaoImpl implements AdDao{

    @Autowired
    AdRepository adRepository;

    public List<Ad> getAllAds() {
        List<Ad> ads = new ArrayList<Ad>();
        Iterator<Ad> i = adRepository.findAll().iterator();
        while (i.hasNext()) {
          ads.add(i.next());
        }
        return ads;
	 }
	 
    public Ad findAdById(Long id) {
        return adRepository.findOne(id);
    }
	 
    public void insertAd(Ad ad) {
        adRepository.save(ad);
    }

    public void updateAd(Ad ad) {
        adRepository.save(ad);
    }

    public void deleteById(Long id) {
        adRepository.delete(id);
    }
}
