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
import br.com.acbueno.catalog.cqrs.comnand.CompactDiscCommandService;
import br.com.acbueno.catalog.cqrs.dto.CompactDiscDTO;
import br.com.acbueno.catalog.cqrs.query.CompactDiscQueryService;


@RestController
@RequestMapping("/api/compactdisc")
public class CompacDiscController {

  @Autowired
  private CompactDiscCommandService commandService;

  @Autowired
  private CompactDiscQueryService queryService;


  @GetMapping
  public ResponseEntity<List<CompactDiscDTO>> getAllCompactDisc() {
    return ResponseEntity.ok().body(queryService.getAllCompactDisc());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<CompactDiscDTO>> getCompactDiscById(
      @PathVariable("id") String id) {
    return ResponseEntity.ok().body(queryService.getCompactDiscById(id));
  }

  @PostMapping
  public ResponseEntity<CompactDiscDTO> create(@RequestBody CompactDiscDTO dto) {
    return ResponseEntity.ok().body(commandService.createCompactDisc(dto));
  }

  @PutMapping("/{id}")
  public ResponseEntity<CompactDiscDTO> updateById(@PathVariable("id") String id,
      @RequestBody CompactDiscDTO dto) {
    return ResponseEntity.ok().body(commandService.updateCompactDisc(id, dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable("id") String id) {
    commandService.deleteCompact(id);
    return ResponseEntity.ok().build();
  }

}
