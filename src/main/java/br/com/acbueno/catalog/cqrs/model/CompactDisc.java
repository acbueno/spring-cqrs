package br.com.acbueno.catalog.cqrs.model;

import org.modelmapper.ModelMapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.acbueno.catalog.cqrs.dto.CompactDiscDTO;
import lombok.Data;

@Document(collection = "compact_disc")
@Data
public class CompactDisc {

  @Id
  private String id;

  private String title;

  private String artist;

  private int year;

  public static CompactDisc convert(CompactDiscDTO dto) {
    ModelMapper mapper = new ModelMapper();
    return mapper.map(dto, CompactDisc.class);
  }

}
