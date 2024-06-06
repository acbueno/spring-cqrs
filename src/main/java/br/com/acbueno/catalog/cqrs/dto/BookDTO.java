package br.com.acbueno.catalog.cqrs.dto;

import org.modelmapper.ModelMapper;
import br.com.acbueno.catalog.cqrs.model.Book;
import lombok.Data;

@Data
public class BookDTO {

  private String title;

  private String author;

  private String isbn;

  public static BookDTO convert(Book book) {
    ModelMapper mapper = new ModelMapper();
    return mapper.map(book, BookDTO.class);
  }

}
