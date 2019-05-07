package com.jca.search.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Service;

import com.jca.search.entity.ProductEntity;

@Service
public class ProductSearch {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ProductEntity> search(String text){
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		
		QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder()
				.forEntity(ProductEntity.class).get();
		
		Query query = queryBuilder
				.keyword()
				.onFields("name", "pricePerUom", "uom","manufacturedYear")
				.matching(text)
				.createQuery();
		
		org.hibernate.search.jpa.FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, ProductEntity.class);
		
		return jpaQuery.getResultList();
	}

}
