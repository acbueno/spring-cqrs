package br.com.acbueno.catalog.cqrs.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import br.com.acbueno.catalog.cqrs.event.BookCreatedEvent;
import br.com.acbueno.catalog.cqrs.model.Book;
import br.com.acbueno.catalog.cqrs.repository.BookRepository;

@Component
public class BookCreatedEventListener {

  private static final Logger LOGGER = LoggerFactory.getLogger(BookCreatedEventListener.class);

  @Autowired
  private BookRepository repository;

  @EventListener
  public void handleBookCreatedEvent(BookCreatedEvent event) {
    Book book = new Book();
    book.setTitle(event.getTitle());
    book.setAuthor(event.getAuthor());
    book.setIsbn(event.getIsbn());
    repository.save(book);
    LOGGER.info(String.format("Book Save title: ", book.getTitle()));
  }

}
