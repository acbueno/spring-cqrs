package br.com.acbueno.catalog.cqrs.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import br.com.acbueno.catalog.cqrs.event.CompactDiscCreatedEvent;
import br.com.acbueno.catalog.cqrs.model.CompactDisc;
import br.com.acbueno.catalog.cqrs.repository.CompactDiscRepository;

@Component
public class CompactDiscCreatedEventListener {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(CompactDiscCreatedEventListener.class);

  @Autowired
  private CompactDiscRepository repository;

  @EventListener
  public void handleCompactDiscCretedEvent(CompactDiscCreatedEvent event) {
    CompactDisc compactDisc = new CompactDisc();
    compactDisc.setTitle(event.getTitle());
    compactDisc.setArtist(event.getArtist());
    compactDisc.setYear(event.getYear());
    repository.save(compactDisc);
  }

}
