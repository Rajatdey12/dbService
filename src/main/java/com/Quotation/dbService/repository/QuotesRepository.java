package com.Quotation.dbService.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.Quotation.dbService.model.Quote;

@Component
public interface QuotesRepository extends JpaRepository<Quote, Integer> {

	public List<Quote> findByUserName(String userName);
	
}
