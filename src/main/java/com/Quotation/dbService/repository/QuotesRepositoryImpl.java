package com.Quotation.dbService.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.Quotation.dbService.model.Quote;

@Component
@Repository
public abstract class QuotesRepositoryImpl implements QuotesRepository{
	
	@Override
	public List<Quote> findByUserName(String userName) {
		return findByUserName(userName);
	}

}
