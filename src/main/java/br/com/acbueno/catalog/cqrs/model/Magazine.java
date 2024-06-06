package br.com.acbueno.catalog.cqrs.model;

import org.modelmapper.ModelMapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.acbueno.catalog.cqrs.dto.MagazineDTO;
import lombok.Data;

@Document(collection = "magazine")
@Data
public class Magazine {

  @Id
  private String id;

  private String title;

  private String editor;

  private int year;

  private int month;

  private int edition;

  public static Magazine convert(MagazineDTO dto) {
    ModelMapper mapper = new ModelMapper();
    return mapper.map(dto, Magazine.class);
  }

}
