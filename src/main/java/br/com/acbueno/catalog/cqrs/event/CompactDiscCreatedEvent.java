package br.com.acbueno.catalog.cqrs.event;

import org.springframework.context.ApplicationEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompactDiscCreatedEvent extends ApplicationEvent {

  private static final long serialVersionUID = 1L;

  private String title;

  private String artist;

  private int year;

  public CompactDiscCreatedEvent(Object source, String title, String artist, int year) {
    super(source);
    this.title = title;
    this.artist = artist;
    this.year = year;
  }

}
