package br.com.acbueno.catalog.cqrs.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import br.com.acbueno.catalog.cqrs.event.MagazineDeleteEvent;
import br.com.acbueno.catalog.cqrs.repository.MagazineRepository;

@Component
public class MagazineDeleteEventListener {


  private static final Logger LOGGER = LoggerFactory.getLogger(MagazineDeleteEventListener.class);

  @Autowired
  private MagazineRepository repository;

  @EventListener
  public void handleMagazineDeletedEvent(MagazineDeleteEvent event) {
    repository.deleteById(event.getId());
    LOGGER.info("Delete Magazine");
  }

}
