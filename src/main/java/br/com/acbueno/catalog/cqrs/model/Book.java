package br.com.acbueno.catalog.cqrs.model;

import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.acbueno.catalog.cqrs.dto.BookDTO;
import lombok.Data;

@Document(collection = "book")
@Data
public class Book {

  private String id;

  private String title;

  private String author;

  private String isbn;

  public static Book convert(BookDTO dto) {
    ModelMapper mapper = new ModelMapper();
    return mapper.map(dto, Book.class);
  }

}
