package edu.marcus.business.controller;

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

	public Iterable<BookBusiness> getAll() {
		return bookFactory.transformEntity(bookRepository.findAll());
	}

	public BookBusiness get(Long oid) {
		return bookRepository.findById(oid)
				.map(bookFactory::transformEntity)
				.orElse(null);
	}

	public BookBusiness add(BookBusiness book) {
		return bookFactory.transformEntity(
				bookRepository.save(
						bookFactory.transformBusinessToEntity(book)));
	}

	public void update(Long oid, BookBusiness book) {
		book.setOid(oid);
		bookRepository.save(bookFactory.transformBusinessToEntity(book));
	}

	public void delete(Long oid) {
		bookRepository.deleteById(oid);
	}

}
