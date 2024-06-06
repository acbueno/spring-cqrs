package br.com.acbueno.catalog.cqrs.query;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.acbueno.catalog.cqrs.dto.MagazineDTO;
import br.com.acbueno.catalog.cqrs.repository.MagazineRepository;

@Service
public class MagazineQueryService {

  @Autowired
  private MagazineRepository repository;


  public List<MagazineDTO> getAllMagazine() {
    //@formatter:off
    return repository.findAll()
        .stream()
        .map(MagazineDTO::convert)
        .collect(Collectors.toList());
    //@formatter:on
  }

  // public List<MagazineDTO> getAllMagazine() {
  // List<MagazineDTO> listDTO = new ArrayList<>();
  // List<Magazine> listEntity = repository.findAll();
  //
  // for (Magazine magazine : listEntity) {
  // listDTO.add(MagazineDTO.convert(magazine));
  // }

  // return listDTO;

  // }

  public Optional<MagazineDTO> getMagazineById(String id) {
    repository.findById(id);
    return Optional.ofNullable(MagazineDTO.convert(repository.findById(id).get()));
  }

}
