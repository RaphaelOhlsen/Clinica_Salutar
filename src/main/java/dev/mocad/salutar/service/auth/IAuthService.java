package dev.mocad.salutar.service.auth;

import dev.mocad.salutar.model.Usuario;
import dev.mocad.salutar.security.SalutarToken;

public interface IAuthService {
  public Usuario criarUsuario(Usuario novo);
  public SalutarToken realizarLogin(Usuario dadosLogin);
}
