package com.anabol.motosearch.dao.old;

import com.anabol.motosearch.model.old.Ad;
import java.util.*;
import org.springframework.stereotype.Repository;
import javax.persistence.*;

@Repository
public class AdDaoJpaHibernate implements AdDao{

    @PersistenceContext(unitName = "MotoSearchJPA")
    private EntityManager em;

    public List<Ad> getAllAds() {
            List<Ad> ads = em.createQuery("FROM Ad", Ad.class).getResultList();
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
        em.merge(ad);
    }

    public void deleteById(Long id) {
        em.remove(findAdById(id));
    }
}
