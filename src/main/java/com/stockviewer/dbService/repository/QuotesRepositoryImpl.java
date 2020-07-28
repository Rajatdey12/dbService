package com.stockviewer.dbService.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.stockviewer.dbService.model.Quote;

@Component
@Repository
public abstract class QuotesRepositoryImpl implements Quotesrepository{
	
	@Override
	public List<Quote> findByUserName(String userName) {
		return findByUserName(userName);
	}

}
