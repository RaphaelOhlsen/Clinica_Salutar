package dev.mocad.salutar.service.midia;

import dev.mocad.salutar.model.Midia;
import org.springframework.stereotype.Component;

public interface IMidiaService {

  public Midia cadastrarNova(Midia midia);
  public Midia alterarDados(Midia midia);
  public boolean excluir(Integer id);
  public Midia recuperarPeloId(Integer id);
}
