package com.stockviewer.dbService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Quotes", catalog = "test")
public class Quote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "Quote_Id")
	private Integer QuoteId;
	@NotNull
	@Column(name = "UserName")
	private String userName;
	@NotNull
	@Column(name = "quotes")
	private  String quote;
	
	public Quote() {
		super();
	}
	
	public Quote(Integer quoteId,String userName, String quote) {
		this.quote = quote;
		this.userName = userName;
		this.QuoteId = quoteId;
	}

	public Integer getQuoteId() {
		return QuoteId;
	}

	public void setQuoteId(Integer quoteId) {
		QuoteId = quoteId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	
}
