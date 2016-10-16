package com.anabol.motosale.dao;

import com.anabol.motosale.model.Ad;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

@Repository
public class AdDaoImpl implements AdDao{
    @Autowired
    private SessionFactory sessionFactory;

    public List<Ad> getAllAds() {
         Session session = sessionFactory.getCurrentSession();
         List<Ad> ads = session.createQuery("FROM Ad").list();
		 return ads;
	 }
	 
	 public Ad findAdById(Long id) {
         Session session = sessionFactory.getCurrentSession();
         Ad ad = (Ad)session.get(Ad.class, id);
         return ad;
	 }
	 
	 public void insertAd(Ad ad) {
         Session session = sessionFactory.getCurrentSession();
         session.save(ad);
	 }

    public void updateAd(Ad ad) {
        Session session = sessionFactory.getCurrentSession();
        Ad existingAd = findAdById(ad.getId());
        existingAd.setTitle(ad.getTitle());
        existingAd.setDescription(ad.getDescription());
        existingAd.setManufacturerId(ad.getManufacturerId());
        existingAd.setModelId(ad.getModelId());
        existingAd.setProduceYear(ad.getProduceYear());
        existingAd.setCapacity(ad.getCapacity());
        existingAd.setMileage(ad.getMileage());
        existingAd.setPhone(ad.getPhone());
        existingAd.setEmail(ad.getEmail());
        existingAd.setStartDate(ad.getStartDate());
        existingAd.setEndDate(ad.getEndDate());
        session.save(existingAd);
    }

    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(findAdById(id));
    }
}
