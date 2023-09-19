package dev.mocad.salutar.service.auth;

import dev.mocad.salutar.dao.UsuarioDAO;
import dev.mocad.salutar.model.Usuario;
import dev.mocad.salutar.security.SalutarToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceImpl implements IAuthService {

  @Autowired
  private UsuarioDAO dao;

  @Override
  public Usuario criarUsuario(Usuario novo) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
    novo.setSenha(encoder.encode(novo.getSenha()));
    return dao.save(novo);
  }

  @Override
  public SalutarToken realizarLogin(Usuario dadosLogin) {
  return null;
  }


}
