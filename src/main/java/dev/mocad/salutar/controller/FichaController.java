package dev.mocad.salutar.controller;

import dev.mocad.salutar.model.FichaPaciente;
import dev.mocad.salutar.service.ficha.IFichaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/fichas")
@CrossOrigin("*")
public class FichaController {

  @Autowired
  private IFichaService service;

  @GetMapping("/busca")
  public ResponseEntity<List<FichaPaciente>> buscarPorNome(@RequestParam(name = "nome") String nome) {
    List<FichaPaciente> lista = service.buscarPorNome(nome);
    if (!lista.isEmpty()) {
      return ResponseEntity.ok(lista);
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<FichaPaciente> cadastrarNovaFIcha(@RequestBody FichaPaciente nova) throws Exception {
    FichaPaciente res = service.cadastrar(nova);
    if (res != null) {
      return ResponseEntity.created(new URI("/fichas/" + res.getIdFicha())).body(res);
    }
    return ResponseEntity.badRequest().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<FichaPaciente> buscarPeloId(@PathVariable Integer id) {
    FichaPaciente res = service.recuperarPeloId(id);
    if (res != null) {
      return ResponseEntity.ok(res);
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/alterar/{id}")
  public ResponseEntity<FichaPaciente> alterarFicha(@RequestBody FichaPaciente ficha, @PathVariable Integer id) {
    if (ficha.getIdFicha() == null) {
      ficha.setIdFicha(id);
    }
    FichaPaciente res = service.alterar(ficha);
    if (res != null) {
      return ResponseEntity.ok(res);
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> excluirFicha(@PathVariable Integer id) {
    if (service.excluir(id)) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
