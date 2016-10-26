package com.anabol.motosale.dao;

import com.anabol.motosale.model.Ad;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Repository
public class AdDaoImpl implements AdDao{
//    @Autowired
//    private SessionFactory sessionFactory;
//    private EntityManagerFactory emf;

//    @PersistenceUnit
//    public void setEntityManagerFactory(EntityManagerFactory emf) {
//        this.emf = emf;
//    }

    @PersistenceContext(name = "MotoSale-JPA")
    private EntityManager entityManager;

    public List<Ad> getAllAds() {
      //   Session session = sessionFactory.getCurrentSession();
      //   List<Ad> ads = session.createQuery("FROM Ad").list();
          List<Ad> ads = entityManager.createQuery("FROM Ad").getResultList();
        return ads;
	 }
	 
	 public Ad findAdById(Long id) {
   //      Session session = sessionFactory.getCurrentSession();
   //      Ad ad = (Ad)session.get(Ad.class, id);
           Ad ad = entityManager.find(Ad.class, id);
         return ad;
	 }
	 
	 public void insertAd(Ad ad) {
 //        Session session = sessionFactory.getCurrentSession();
 //        session.save(ad);
         entityManager.persist(ad);
	 }

    public void updateAd(Ad ad) {
//        Session session = sessionFactory.getCurrentSession();
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
//        session.save(existingAd);
        entityManager.persist(existingAd);
    }

    public void deleteById(Long id) {
 //       Session session = sessionFactory.getCurrentSession();
 //       session.delete(findAdById(id));
          entityManager.detach(findAdById(id));
    }
}
