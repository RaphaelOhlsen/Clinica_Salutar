package dev.mocad.salutar.service.ficha;

import dev.mocad.salutar.dao.FichaPacienteDAO;
import dev.mocad.salutar.model.FichaPaciente;
import org.slf4j.ILoggerFactory;
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

  public FichaPaciente alterar(FichaPaciente ficha) {
    FichaPaciente tmp = dao.findById(ficha.getIdFicha()).orElse(null);
    if (tmp != null) {
      if (ficha.getAtivo() != null) {
        tmp.setAtivo(ficha.getAtivo());
      }
      return dao.save(ficha);
    }
    return null;
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
    FichaPaciente token = recuperarPeloId(id);
    if (token != null) {
      token.setAtivo(0);
      dao.save(token);
      return true;
    }
    return false;
  }
}
