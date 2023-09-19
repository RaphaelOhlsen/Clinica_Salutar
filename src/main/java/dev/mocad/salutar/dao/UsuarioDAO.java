package dev.mocad.salutar.dao;

import dev.mocad.salutar.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDAO extends CrudRepository<Usuario,Integer>{
  public Usuario findByLogin(String login);
}
