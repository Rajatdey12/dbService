package com.stockviewer.dbService.resource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stockviewer.dbService.model.Quote;
import com.stockviewer.dbService.repository.Quotesrepository;

@Component
@RestController
@RequestMapping("/rest/db")
public class DBServiceResource {
	
	@Autowired
	private Quotesrepository quoteRepository;
	
	@GetMapping("/{user}")
	public List<String> getQuotes(@PathVariable("user") final String userName){
		
		return quoteRepository.findByUserName(userName)
		.stream()
		.flatMap(e -> Stream.of(e.getUserName(), e.getQuote()))
		.collect(Collectors.toList());
		
	}
	
	@PostMapping("/quotes")
	public Quote CreateQuote(@Valid @RequestBody Quote quotes) {
		return quoteRepository.save(quotes);
	}
	
	@DeleteMapping("/delQuotes/{id}")
	public List<Quote> deleteQuoteId(@PathVariable("id") final Integer id) {
		 quoteRepository.deleteById(id);
		return quoteRepository.findAll();
	}

}
