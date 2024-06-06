package br.com.acbueno.catalog.cqrs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.acbueno.catalog.cqrs.model.Magazine;

@Repository
public interface MagazineRepository extends MongoRepository<Magazine, String> {

}
