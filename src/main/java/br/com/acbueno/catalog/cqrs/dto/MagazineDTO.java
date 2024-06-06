package br.com.acbueno.catalog.cqrs.dto;

import org.modelmapper.ModelMapper;
import br.com.acbueno.catalog.cqrs.model.Magazine;
import lombok.Data;

@Data
public class MagazineDTO {

  private String title;

  private String editor;

  private int year;

  private int month;

  private int edition;

  public static MagazineDTO convert(Magazine entity) {
    ModelMapper mapper = new ModelMapper();
    return mapper.map(entity, MagazineDTO.class);
  }

}
