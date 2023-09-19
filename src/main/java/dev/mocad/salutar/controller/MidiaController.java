package dev.mocad.salutar.controller;

import dev.mocad.salutar.model.Midia;
import dev.mocad.salutar.service.midia.IMidiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/midias")
@CrossOrigin("*")
public class MidiaController {

  @Autowired
  private IMidiaService service;

  @GetMapping("/{id}")
  public ResponseEntity<Midia> recuperarPeloId(@PathVariable Integer id) {
    Midia res = service.recuperarPeloId(id);
    if (res != null) {
      return ResponseEntity.ok(res);
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<Midia> adicionarNova(@RequestBody Midia midia) throws Exception {
    Midia res = service.cadastrarNova(midia);
    if (res != null) {
      return ResponseEntity.status(201).body(res);
    }
    return ResponseEntity.badRequest().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Midia> alterarDados(@PathVariable Integer id, @RequestBody Midia midia) {
    if (midia.getNumSeq() == null) {
      midia.setNumSeq(id);
    }
    Midia res = service.alterarDados(midia);
    if (res != null) {
      return ResponseEntity.ok(res);
    }
    return ResponseEntity.badRequest().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> excluirMidia(@PathVariable Integer id) {
    if (service.excluir(id)) {
      return ResponseEntity.ok("OK");
    }
    return ResponseEntity.notFound().build();
  }
}
