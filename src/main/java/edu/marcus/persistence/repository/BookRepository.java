package edu.marcus.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import edu.marcus.persistence.entity.BookEntity;

public interface BookRepository extends CrudRepository<BookEntity, Long> {

}
