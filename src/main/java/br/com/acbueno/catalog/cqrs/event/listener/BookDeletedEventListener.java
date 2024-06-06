package br.com.acbueno.catalog.cqrs.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import br.com.acbueno.catalog.cqrs.event.BookDeleteEvent;
import br.com.acbueno.catalog.cqrs.repository.BookRepository;

@Component
public class BookDeletedEventListener {

  private static final Logger LOGGER = LoggerFactory.getLogger(BookDeletedEventListener.class);

  @Autowired
  private BookRepository repository;

  @EventListener
  public void handleBookDeletedEvent(BookDeleteEvent event) {
    repository.deleteById(event.getId());
    LOGGER.info("Delete Book");
  }

}
