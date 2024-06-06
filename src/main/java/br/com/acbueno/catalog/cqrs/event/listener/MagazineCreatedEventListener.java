package br.com.acbueno.catalog.cqrs.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import br.com.acbueno.catalog.cqrs.event.MagazineCreatedEvent;
import br.com.acbueno.catalog.cqrs.model.Magazine;
import br.com.acbueno.catalog.cqrs.repository.MagazineRepository;

@Component
public class MagazineCreatedEventListener {

  private static final Logger LOGGER = LoggerFactory.getLogger(MagazineCreatedEventListener.class);

  @Autowired
  private MagazineRepository repository;

  @EventListener
  public void handleMagazineCreatedEvent(MagazineCreatedEvent event) {
    Magazine magazine = new Magazine();
    magazine.setTitle(event.getTitle());
    magazine.setEditor(event.getEditor());
    magazine.setYear(event.getYear());
    magazine.setMonth(event.getMonth());
    magazine.setEdition(event.getEdition());
    repository.save(magazine);
    LOGGER.info("Magazine saved");
  }

}
