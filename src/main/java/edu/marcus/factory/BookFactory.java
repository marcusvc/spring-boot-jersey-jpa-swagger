package edu.marcus.factory;

import org.springframework.stereotype.Component;

import edu.marcus.business.domain.BookBusiness;
import edu.marcus.persistence.entity.BookEntity;
import edu.marcus.rest.dto.BookDTO;

@Component
public class BookFactory {

	public BookDTO transformToDTO(BookBusiness book) {
		if (book != null) {
			BookDTO dto = new BookDTO();
			dto.setAuthor(book.getAuthor());
			dto.setEdition(book.getEdition());
			dto.setName(book.getName());
			dto.setOid(book.getOid());
			dto.setPublisher(book.getPublisher());
			dto.setYear(book.getYear());
			return dto;
		}
		return null;
	}

	public BookEntity transformToEntity(BookBusiness book) {
		if (book != null) {
			BookEntity entity = new BookEntity();
			entity.setAuthor(book.getAuthor());
			entity.setEdition(book.getEdition());
			entity.setName(book.getName());
			entity.setOid(book.getOid());
			entity.setPublisher(book.getPublisher());
			entity.setYear(book.getYear());
			return entity;
		}
		return null;
	}

	public BookBusiness transformToBusiness(BookDTO dto) {
		if (dto != null) {
			BookBusiness book = new BookBusiness();
			book.setAuthor(dto.getAuthor());
			book.setEdition(dto.getEdition());
			book.setName(dto.getName());
			book.setOid(dto.getOid());
			book.setPublisher(dto.getPublisher());
			book.setYear(dto.getYear());
			return book;
		}
		return null;
	}

	public BookBusiness transformToBusiness(BookEntity entity) {
		if (entity != null) {
			BookBusiness book = new BookBusiness();
			book.setAuthor(entity.getAuthor());
			book.setEdition(entity.getEdition());
			book.setName(entity.getName());
			book.setOid(entity.getOid());
			book.setPublisher(entity.getPublisher());
			book.setYear(entity.getYear());
			return book;
		}
		return null;
	}

}
