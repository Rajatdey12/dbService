package com.stockviewer.dbService.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.stockviewer.dbService.model.Quote;

@Component
public interface Quotesrepository extends JpaRepository<Quote, Integer> {

	public List<Quote> findByUserName(String userName);
	
}
