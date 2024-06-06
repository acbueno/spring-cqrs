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
import br.com.acbueno.catalog.cqrs.comnand.BookCommandService;
import br.com.acbueno.catalog.cqrs.dto.BookDTO;
import br.com.acbueno.catalog.cqrs.query.BookQueryService;



@RestController
@RequestMapping("/api/books")
public class BookController {

  @Autowired
  private BookCommandService commandService;

  @Autowired
  private BookQueryService queryService;

  @GetMapping
  public ResponseEntity<List<BookDTO>> getAllBooks() {
    return ResponseEntity.ok().body(queryService.getAllBooks());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<BookDTO>> getMethodName(@PathVariable("id") String id) {
    return ResponseEntity.ok().body(queryService.getBookByIdString(id));
  }

  @PostMapping
  public ResponseEntity<BookDTO> create(@RequestBody BookDTO dto) {
    return ResponseEntity.ok().body(commandService.create(dto));
  }

  @PutMapping("/{id}")
  public ResponseEntity<BookDTO> update(@PathVariable("id") String id, @RequestBody BookDTO dto) {
    return ResponseEntity.ok().body(commandService.updateBook(id, dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable("id") String id) {
    commandService.deleteBook(id);
    return ResponseEntity.ok().build();
  }

}
