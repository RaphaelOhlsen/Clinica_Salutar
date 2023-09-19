package dev.mocad.salutar.controller;

import dev.mocad.salutar.model.Usuario;
import dev.mocad.salutar.service.auth.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AuthController {

  @Autowired
  private IAuthService service;

  @PostMapping("/usuarios")
  public ResponseEntity<Usuario> adicionarNovo(@RequestBody Usuario novo) {
    Usuario res = service.criarUsuario(novo);
    if (res != null) {
      return ResponseEntity.ok(res);
    }
    return ResponseEntity.badRequest().build();
  }
}
