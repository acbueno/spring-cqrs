package br.com.acbueno.catalog.cqrs.comnand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import br.com.acbueno.catalog.cqrs.dto.CompactDiscDTO;
import br.com.acbueno.catalog.cqrs.event.CompactDiscCreatedEvent;
import br.com.acbueno.catalog.cqrs.event.CompactDiscDeleteEvent;
import br.com.acbueno.catalog.cqrs.model.CompactDisc;
import br.com.acbueno.catalog.cqrs.repository.CompactDiscRepository;

@Service
public class CompactDiscCommandService {

  @Autowired
  private CompactDiscRepository repository;

  @Autowired
  private ApplicationEventPublisher eventPublisher;

  public CompactDiscDTO createCompactDisc(CompactDiscDTO dto) {
    try {
      //@formatter:off
      eventPublisher.publishEvent(new CompactDiscCreatedEvent(this,
          dto.getTitle(), 
          dto.getArtist(), 
          dto.getYear()));
      //@fomatter:on
    } catch (Exception e) {
      e.printStackTrace();
    }
    return dto;
  }

  public CompactDiscDTO updateCompactDisc(String id, CompactDiscDTO dto) {
    return repository.findById(id).map(cd -> {
      cd.setTitle(dto.getTitle());
      cd.setArtist(dto.getArtist());
      cd.setYear(cd.getYear());
      return CompactDiscDTO.convert(repository.save(CompactDisc.convert(dto)));
    }).orElse(null);
  }

  public void deleteCompact(String id) {
    eventPublisher.publishEvent(new CompactDiscDeleteEvent(this,id));
  }

}
