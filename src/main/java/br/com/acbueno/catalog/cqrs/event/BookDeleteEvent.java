package br.com.acbueno.catalog.cqrs.event;

import org.springframework.context.ApplicationEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDeleteEvent extends ApplicationEvent {

  private static final long serialVersionUID = 1L;

  private String id;

  public BookDeleteEvent(Object source, String id) {
    super(source);
    this.id = id;
  }

}
