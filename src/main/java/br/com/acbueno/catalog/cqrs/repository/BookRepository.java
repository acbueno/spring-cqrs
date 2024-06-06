package br.com.acbueno.catalog.cqrs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.acbueno.catalog.cqrs.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

}
