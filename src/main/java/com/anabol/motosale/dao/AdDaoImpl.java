package com.anabol.motosale.dao;

import com.anabol.motosale.model.Ad;
import java.util.*;
import org.springframework.stereotype.Repository;
import javax.persistence.*;

@Repository
public class AdDaoImpl implements AdDao{

    @PersistenceUnit(unitName = "MotoSaleJPA")
    private EntityManagerFactory emf;

    public List<Ad> getAllAds() {
            EntityManager em = emf.createEntityManager();
            List<Ad> ads = em.createQuery("FROM Ad").getResultList();
        return ads;
	 }
	 
	 public Ad findAdById(Long id) {
           EntityManager em = emf.createEntityManager();
           Ad ad = em.find(Ad.class, id);
         return ad;
	 }
	 
	 public void insertAd(Ad ad) {
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
         em.persist(ad);
         em.getTransaction().commit();
         em.close();
	 }

    public void updateAd(Ad ad) {
        EntityManager em = emf.createEntityManager();
        Ad existingAd = em.getReference(Ad.class, ad.getId());
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
        em.getTransaction().begin();
        em.merge(existingAd);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteById(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.getReference(Ad.class, id));
        em.getTransaction().commit();
        em.close();
    }
}
