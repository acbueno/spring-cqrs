package br.com.acbueno.catalog.cqrs.event;

import org.springframework.context.ApplicationEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookCreatedEvent extends ApplicationEvent {

  private static final long serialVersionUID = 1L;

  private String title;

  private String author;

  private String isbn;

  public BookCreatedEvent(Object source, String title, String author, String isbn) {
    super(source);
    this.title = title;
    this.author = author;
    this.isbn = isbn;
  }

}
