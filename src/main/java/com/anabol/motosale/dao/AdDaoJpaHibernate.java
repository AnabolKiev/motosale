package com.anabol.motosale.dao;

import com.anabol.motosale.model.Ad;
import java.util.*;
import org.springframework.stereotype.Repository;
import javax.persistence.*;

@Repository
public class AdDaoJpaHibernate implements AdDao{

    @PersistenceContext(unitName = "MotoSaleJPA")
    private EntityManager em;

    public List<Ad> getAllAds() {
            List<Ad> ads = em.createQuery("FROM Ad").getResultList();
        return ads;
	 }
	 
	 public Ad findAdById(Long id) {
           Ad ad = em.find(Ad.class, id);
         return ad;
	 }
	 
	 public void insertAd(Ad ad) {
         em.persist(ad);
	 }

    public void updateAd(Ad ad) {
        Ad existingAd = findAdById(ad.getId());
        existingAd.setTitle(ad.getTitle());
        existingAd.setDescription(ad.getDescription());
        existingAd.setManufacturer(ad.getManufacturer());
        existingAd.setModelId(ad.getModelId());
        existingAd.setProduceYear(ad.getProduceYear());
        existingAd.setCapacity(ad.getCapacity());
        existingAd.setMileage(ad.getMileage());
        existingAd.setPhone(ad.getPhone());
        existingAd.setEmail(ad.getEmail());
        existingAd.setStartDate(ad.getStartDate());
        existingAd.setEndDate(ad.getEndDate());
    }

    public void deleteById(Long id) {
        em.remove(findAdById(id));
    }
}
