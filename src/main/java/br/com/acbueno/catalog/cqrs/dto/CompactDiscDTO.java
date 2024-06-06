package br.com.acbueno.catalog.cqrs.dto;

import org.modelmapper.ModelMapper;
import br.com.acbueno.catalog.cqrs.model.CompactDisc;
import lombok.Data;

@Data
public class CompactDiscDTO {

  private String title;

  private String artist;

  private int year;

  public static CompactDiscDTO convert(CompactDisc entity) {
    ModelMapper mapper = new ModelMapper();
    return mapper.map(entity, CompactDiscDTO.class);
  }

}
