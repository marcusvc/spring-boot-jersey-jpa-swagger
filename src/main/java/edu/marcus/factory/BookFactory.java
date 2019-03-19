package edu.marcus.factory;

import org.springframework.stereotype.Component;

import edu.marcus.business.domain.BookBusiness;
import edu.marcus.persistence.entity.BookEntity;
import edu.marcus.rest.dto.BookDTO;

@Component
public class BookFactory {

	public Iterable<BookDTO> transformBusiness(Iterable<BookBusiness> books) {
		// TODO Auto-generated method stub
		return null;
	}

	public BookDTO transformBusinessToDTO(BookBusiness book) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public BookEntity transformBusinessToEntity(BookBusiness book) {
		// TODO Auto-generated method stub
		return null;
	}

	public BookBusiness transformDTO(BookDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<BookBusiness> transformEntity(Iterable<BookEntity> entities) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public BookBusiness transformEntity(BookEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
