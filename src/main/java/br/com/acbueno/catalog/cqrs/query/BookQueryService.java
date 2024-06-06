package br.com.acbueno.catalog.cqrs.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.acbueno.catalog.cqrs.dto.BookDTO;
import br.com.acbueno.catalog.cqrs.model.Book;
import br.com.acbueno.catalog.cqrs.repository.BookRepository;

@Service
public class BookQueryService {

  @Autowired
  private BookRepository repository;

  public List<BookDTO> getAllBooks() {
    List<BookDTO> listDTO = new ArrayList<>();
    List<Book> listEntity = repository.findAll();

    for (Book book : listEntity) {
      listDTO.add(BookDTO.convert(book));
    }

    return listDTO;
  }

  public Optional<BookDTO> getBookByIdString(String id) {
    return Optional.ofNullable(BookDTO.convert(repository.findById(id).get()));
  }

}
