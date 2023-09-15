package dev.mocad.salutar.service.ficha;

import dev.mocad.salutar.dao.FichaPacienteDAO;
import dev.mocad.salutar.model.FichaPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class FichaServiceImpl implements IFichaService {

  @Autowired
  private FichaPacienteDAO dao;

  @Override
  public FichaPaciente cadastrar(FichaPaciente nova) {
    nova.setUuid(UUID.randomUUID().toString());
    nova.setAtivo(1);
    return dao.save(nova);
  }

  @Override
  public FichaPaciente alterar(FichaPaciente ficha) {
    return dao.save(ficha);
  }

  @Override
  public List<FichaPaciente> buscarPorNome(String nome) {
    return dao.findByNomePacienteContaining(nome);
  }

  @Override
  public FichaPaciente recuperarPeloId(Integer id) {
    return dao.findById(id).orElse(null);
  }

  @Override
  public boolean excluir(Integer id) {
    FichaPaciente ficha = recuperarPeloId(id);
    if (ficha != null) {
      ficha.setAtivo(0);
      alterar(ficha);
      return true;
    }
    return false;
  }
}
