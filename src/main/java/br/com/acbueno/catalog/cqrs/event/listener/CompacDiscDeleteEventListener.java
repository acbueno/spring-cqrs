package br.com.acbueno.catalog.cqrs.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import br.com.acbueno.catalog.cqrs.event.CompactDiscDeleteEvent;
import br.com.acbueno.catalog.cqrs.repository.CompactDiscRepository;

@Component
public class CompacDiscDeleteEventListener {

  private static final Logger LOGGER = LoggerFactory.getLogger(CompacDiscDeleteEventListener.class);

  @Autowired
  private CompactDiscRepository repository;

  @EventListener
  public void handleCompactDiscDeleteEvent(CompactDiscDeleteEvent event) {
    repository.deleteById(event.getId());
    LOGGER.info("Compact Disc Delete");
  }

}
