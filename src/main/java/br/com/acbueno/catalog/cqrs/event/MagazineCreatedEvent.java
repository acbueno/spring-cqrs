package br.com.acbueno.catalog.cqrs.event;

import org.springframework.context.ApplicationEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MagazineCreatedEvent extends ApplicationEvent {

  private static final long serialVersionUID = 1L;

  private String title;

  private String editor;

  private int year;

  private int month;

  private int edition;

  public MagazineCreatedEvent(Object source, String title, String editor, int year, int month,
      int edition) {
    super(source);
    this.title = title;
    this.editor = editor;
    this.year = year;
    this.month = month;
    this.edition = edition;
  }

}
