package com.anabol.motosearch.service.impl;

import com.anabol.motosearch.dao.repository.ModelRepository;
import com.anabol.motosearch.model.BikeModel;
import com.anabol.motosearch.model.BikeModel_;
import com.anabol.motosearch.model.Manufacturer;
import com.anabol.motosearch.model.Manufacturer_;
import com.anabol.motosearch.service.BikeModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.*;

@Service
public class BikeModelServiceImpl implements BikeModelService{

    @Autowired
    private ModelRepository modelDao;
    @PersistenceContext(unitName = "MotoSearchJPA")
    private EntityManager em;

    public void delete(Long modelId) {
        modelDao.delete(modelId);
    }

    public BikeModel findOne(Long modelId) {
        return modelDao.findOne(modelId);
    }

    public void save(BikeModel bikeModel) {
        modelDao.save(bikeModel);
    }

    public List<BikeModel> findByManufacturer(Long id) {
        return modelDao.findByManufacturer_Id(id);
    }

    public List<Object[]> findAggregatedByManufacturer(Long id) {
/*        Iterator<BikeModel> modelIterator = modelDao.findByManufacturer_IdAndManufacturer_ActiveTrue(id).iterator();
        Map<String, Set<Integer>> modelMap = new TreeMap<>(); 	// Sorted map. Key - unique models, Values - years
        while (modelIterator.hasNext()) {
            BikeModel bikeModel = modelIterator.next();
            if (!modelMap.containsKey(bikeModel.getName())) {  	// create new record in map
                modelMap.put(bikeModel.getName(), new TreeSet<>());
            }
            modelMap.get(bikeModel.getName()).add(bikeModel.getYear());  // adding year
        }*/
        List<Long> manufacturers = new ArrayList<>();
        manufacturers.add(id);
        return findAggregatedByFilters(manufacturers, null, null, null, null, null, null, null, null);
    }

    public List<BikeModel> findByActiveManufacturer(Long id) {
        return modelDao.findByManufacturer_IdAndManufacturer_ActiveTrue(id);
    }

    public BikeModel findByKey(Long manufacturerId, String modelName, Integer year) {
        return modelDao.findByManufacturer_IdAndNameAndYearAndManufacturer_ActiveTrue(manufacturerId, modelName, year);
    }

    public Page<BikeModel> findByFilters(List<Long> manufacturers, // not using at the moment
                                         List<Long> categories,
                                         List<Long> engineTypes,
                                         List<Long> finalDriveTypes,
                                         Integer yearFrom,
                                         Integer yearTo,
                                         Integer displacementFrom,
                                         Integer displacementTo,
                                         String searchText,
                                         Integer sizePerPage,
                                         Integer pageNumber) {
        Specification<BikeModel> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();   // Constructing list of parameters
            Join<BikeModel,Manufacturer> manufacturerJoin= root.join(BikeModel_.manufacturer); // to avoid duplicated joins of Manufacturer for text search
            predicates.add(cb.isTrue(manufacturerJoin.get(Manufacturer_.active)));
            if (manufacturers != null) {
                predicates.add(root.get(BikeModel_.manufacturer).in(manufacturers));
            }
            if (categories != null) {
                predicates.add(root.get(BikeModel_.category).in(categories));
            }
            if (engineTypes != null) {
                predicates.add(root.get(BikeModel_.engineType).in(engineTypes));
            }
            if (finalDriveTypes != null) {
                predicates.add(root.get(BikeModel_.finalDriveType).in(finalDriveTypes));
            }
            if (yearFrom != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get(BikeModel_.year), yearFrom));
            }
            if (yearTo != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get(BikeModel_.year), yearTo));
            }
            if (displacementFrom != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get(BikeModel_.displacement), displacementFrom.floatValue()));
            }
            if (displacementTo != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get(BikeModel_.displacement), displacementTo.floatValue()));
            }
            if (searchText != null) {
                String searchExpr = '%' + searchText.replace(' ', '%') + '%';
                Expression<String> expr1 = cb.concat(manufacturerJoin.get(Manufacturer_.name), root.get(BikeModel_.name));
                Expression<String> expr2 = cb.concat(root.get(BikeModel_.name), manufacturerJoin.get(Manufacturer_.name));
                predicates.add(cb.or(cb.like(expr1, searchExpr), cb.like(expr2, searchExpr)));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        return modelDao.findAll(spec, new PageRequest(pageNumber, sizePerPage));
    }

    public List<Object[]> findAggregatedByFilters(List<Long> manufacturers,
                                                   List<Long> categories,
                                                   List<Long> engineTypes,
                                                   List<Long> finalDriveTypes,
                                                   Integer yearFrom,
                                                   Integer yearTo,
                                                   Integer displacementFrom,
                                                   Integer displacementTo,
                                                   String searchText) {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
        Root<BikeModel> root = query.from(BikeModel.class);
        Join<BikeModel,Manufacturer> manufacturerJoin = root.join(BikeModel_.manufacturer); // to avoid duplicated joins of Manufacturer for text search
        manufacturerJoin.on(cb.isTrue(manufacturerJoin.get(Manufacturer_.active)));
        query.multiselect(manufacturerJoin.get(Manufacturer_.name), root.get(BikeModel_.name), cb.function("group_concat", String.class, root.get(BikeModel_.year)));
        query.groupBy(manufacturerJoin.get(Manufacturer_.name), root.get(BikeModel_.name));
        query.orderBy(cb.asc(manufacturerJoin.get(Manufacturer_.name)), cb.asc(root.get(BikeModel_.name)));

        List<Predicate> predicates = new ArrayList<>();   // Constructing list of parameters
        if (manufacturers != null) {
            predicates.add(root.get(BikeModel_.manufacturer).in(manufacturers));
        }
        if (categories != null) {
            predicates.add(root.get(BikeModel_.category).in(categories));
        }
        if (engineTypes != null) {
            predicates.add(root.get(BikeModel_.engineType).in(engineTypes));
        }
        if (finalDriveTypes != null) {
            predicates.add(root.get(BikeModel_.finalDriveType).in(finalDriveTypes));
        }
        if (yearFrom != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get(BikeModel_.year), yearFrom));
        }
        if (yearTo != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get(BikeModel_.year), yearTo));
        }
        if (displacementFrom != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get(BikeModel_.displacement), displacementFrom.floatValue()));
        }
        if (displacementTo != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get(BikeModel_.displacement), displacementTo.floatValue()));
        }
        if (searchText != null) {
            String searchExpr = '%' + searchText.replace(' ', '%') + '%';
            Expression<String> expr1 = cb.concat(manufacturerJoin.get(Manufacturer_.name), root.get(BikeModel_.name));
            Expression<String> expr2 = cb.concat(root.get(BikeModel_.name), manufacturerJoin.get(Manufacturer_.name));
            predicates.add(cb.or(cb.like(expr1, searchExpr), cb.like(expr2, searchExpr)));
        }
        query.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        return em.createQuery(query).getResultList();
    }

}
