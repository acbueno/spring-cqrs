package br.com.acbueno.catalog.cqrs.comnand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import br.com.acbueno.catalog.cqrs.dto.MagazineDTO;
import br.com.acbueno.catalog.cqrs.event.MagazineCreatedEvent;
import br.com.acbueno.catalog.cqrs.event.MagazineDeleteEvent;
import br.com.acbueno.catalog.cqrs.model.Magazine;
import br.com.acbueno.catalog.cqrs.repository.MagazineRepository;

@Service
public class MagazineCommandService {

  @Autowired
  private MagazineRepository repository;

  @Autowired
  private ApplicationEventPublisher eventPublisher;

  public MagazineDTO createMagazine(MagazineDTO dto) {
    try {
     //@formatter:off
     eventPublisher.publishEvent(new MagazineCreatedEvent(this, 
         dto.getTitle(), 
         dto.getEditor(), 
         dto.getYear(), 
         dto.getMonth(), 
         dto.getEdition()));
     //@formatter:on     
    } catch (Exception e) {
      e.printStackTrace();
    }
    return dto;
  }

  public MagazineDTO updateMagazine(String id, MagazineDTO dto) {
    return repository.findById(id).map(magazine -> {
      magazine.setTitle(dto.getTitle());
      magazine.setEditor(dto.getEditor());
      magazine.setYear(dto.getYear());
      magazine.setMonth(dto.getMonth());
      magazine.setEdition(dto.getEdition());

      return MagazineDTO.convert(repository.save(Magazine.convert(dto)));
    }).orElse(null);
  }

  public void deleteMagazine(String id) {
    eventPublisher.publishEvent(new MagazineDeleteEvent(this, id));
  }

}
