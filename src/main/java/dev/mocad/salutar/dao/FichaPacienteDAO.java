package dev.mocad.salutar.dao;

import dev.mocad.salutar.model.FichaPaciente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FichaPacienteDAO extends CrudRepository<FichaPaciente, Integer> {
  public List<FichaPaciente> findByNomePacienteContaining(String palavraChave);
}
