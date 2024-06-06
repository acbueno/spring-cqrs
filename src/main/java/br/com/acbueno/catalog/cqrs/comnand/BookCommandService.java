package br.com.acbueno.catalog.cqrs.comnand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import br.com.acbueno.catalog.cqrs.dto.BookDTO;
import br.com.acbueno.catalog.cqrs.event.BookCreatedEvent;
import br.com.acbueno.catalog.cqrs.event.BookDeleteEvent;
import br.com.acbueno.catalog.cqrs.repository.BookRepository;

@Service
public class BookCommandService {

  @Autowired
  private BookRepository repository;

  @Autowired
  private ApplicationEventPublisher eventPublisher;

  public BookDTO create(BookDTO dto) {
    try {
      eventPublisher
          .publishEvent(new BookCreatedEvent(this, dto.getTitle(), dto.getAuthor(), dto.getIsbn()));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return dto;
  }

  public BookDTO updateBook(String id, BookDTO dto) {
    return repository.findById(id).map(book -> {
      book.setTitle(dto.getTitle());
      book.setAuthor(dto.getAuthor());
      book.setIsbn(dto.getIsbn());
      return BookDTO.convert(repository.save(book));
    }).orElse(null);
  }

  public void deleteBook(String id) {
    eventPublisher.publishEvent(new BookDeleteEvent(this, id));
  }

}
