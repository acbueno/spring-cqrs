package br.com.acbueno.catalog.cqrs.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.acbueno.catalog.cqrs.comnand.MagazineCommandService;
import br.com.acbueno.catalog.cqrs.dto.MagazineDTO;
import br.com.acbueno.catalog.cqrs.query.MagazineQueryService;

@RestController
@RequestMapping("/api/magazines")
public class MagazineController {

  @Autowired
  private MagazineCommandService commandService;

  @Autowired
  private MagazineQueryService queryService;


  @GetMapping
  public ResponseEntity<List<MagazineDTO>> getAllMagazines() {
    return ResponseEntity.ok().body(queryService.getAllMagazine());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<MagazineDTO>> getMagazineById(@PathVariable("id") String id) {
    return ResponseEntity.ok().body(queryService.getMagazineById(id));
  }

  @PostMapping
  public ResponseEntity<MagazineDTO> create(@RequestBody MagazineDTO dto) {
    return ResponseEntity.ok().body(commandService.createMagazine(dto));
  }

  @PutMapping("/{id}")
  public ResponseEntity<MagazineDTO> updateById(@PathVariable("id") String id,
      @RequestBody MagazineDTO dto) {
    return ResponseEntity.ok().body(commandService.updateMagazine(id, dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable("id") String id) {
    commandService.deleteMagazine(id);
    return ResponseEntity.ok().build();
  }

}
