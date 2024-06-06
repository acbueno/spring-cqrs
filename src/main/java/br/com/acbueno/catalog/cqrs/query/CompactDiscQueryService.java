package br.com.acbueno.catalog.cqrs.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.acbueno.catalog.cqrs.dto.CompactDiscDTO;
import br.com.acbueno.catalog.cqrs.repository.CompactDiscRepository;

@Service
public class CompactDiscQueryService {

  @Autowired
  private CompactDiscRepository repository;

  public List<CompactDiscDTO> getAllCompactDisc() {
    List<CompactDiscDTO> listDTO = new ArrayList<>();
    repository.findAll().forEach(it -> {
      listDTO.add(CompactDiscDTO.convert(it));
    });

    return listDTO;
  }

  public Optional<CompactDiscDTO> getCompactDiscById(String id) {
    return Optional.ofNullable(CompactDiscDTO.convert(repository.findById(id).get()));
  }

}
