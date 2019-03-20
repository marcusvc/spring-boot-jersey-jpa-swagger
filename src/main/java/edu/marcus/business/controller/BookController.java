package edu.marcus.business.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Component;

import edu.marcus.business.domain.BookBusiness;
import edu.marcus.factory.BookFactory;
import edu.marcus.persistence.repository.BookRepository;

@Component
public class BookController {
	
	private BookRepository bookRepository;
	private BookFactory bookFactory;
	
	public BookController(BookRepository bookRepository, BookFactory bookFactory) {
		this.bookRepository = bookRepository;
		this.bookFactory = bookFactory;
	}

	public List<BookBusiness> getAll() {
		return StreamSupport.stream(bookRepository.findAll().spliterator(), false)
				.map(bookFactory::transformToBusiness)
				.collect(Collectors.toList());
	}

	public BookBusiness get(Long oid) {
		return bookRepository.findById(oid)
				.map(bookFactory::transformToBusiness)
				.orElse(null);
	}

	public BookBusiness add(BookBusiness book) {
		return bookFactory.transformToBusiness(
				bookRepository.save(
						bookFactory.transformToEntity(book)));
	}

	public void update(Long oid, BookBusiness book) {
		book.setOid(oid);
		bookRepository.save(bookFactory.transformToEntity(book));
	}

	public void delete(Long oid) {
		bookRepository.deleteById(oid);
	}

}
