package dev.mocad.salutar.service.midia;

import dev.mocad.salutar.dao.MidiaDAO;
import dev.mocad.salutar.model.Midia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MidiaSeviceImpl implements IMidiaService{

  @Autowired
  private MidiaDAO dao;

  @Override
  public Midia cadastrarNova(Midia midia) {
    return dao.save(midia);
  }

  @Override
  public Midia alterarDados(Midia midia) {
    return dao.save(midia);
  }

  @Override
  public boolean excluir(Integer id) {
    if (dao.existsById(id)) {
      dao.deleteById(id);
      return true;
    }
    return false;
  }

  @Override
  public Midia recuperarPeloId(Integer id) {
    return dao.findById(id).orElse(null);
  }
}
