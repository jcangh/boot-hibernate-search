package com.jca.search.index;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SearchIndexer implements ApplicationListener<ApplicationReadyEvent>{
	
	Logger logger = LoggerFactory.getLogger(SearchIndexer.class);
	 
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		try {
			FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
			fullTextEntityManager.createIndexer().startAndWait();
		}catch(InterruptedException ex) {
			ex.printStackTrace();
			logger.error("Error creating indexer", ex);
		}
		return;
	}

}
