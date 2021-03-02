package com.Quotation.dbService.repository;

import java.util.List;

import com.Quotation.dbService.model.Quote;

public abstract class QuotesRepositoryImpl implements QuotesRepository{
	
	@Override
	public List<Quote> findByUserName(String userName) {
		return findByUserName(userName);
	}

	@Override
	public Quote getUserByUserName(String userName) {
		return getUserByUserName(userName);
	}

}
