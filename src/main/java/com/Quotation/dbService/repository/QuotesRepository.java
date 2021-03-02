package com.Quotation.dbService.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Quotation.dbService.model.Quote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface QuotesRepository extends JpaRepository<Quote, Integer> {

	public List<Quote> findByUserName(String userName);

	@Query("SELECT q FROM Quote q WHERE q.userName = :userName")
	public Quote getUserByUserName(@Param("userName") String userName);
	
}
