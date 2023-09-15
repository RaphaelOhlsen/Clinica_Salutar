package dev.mocad.salutar.service.ficha;

import dev.mocad.salutar.model.FichaPaciente;

import java.util.List;

public interface IFichaService {

  public FichaPaciente cadastrar(FichaPaciente nova);
  public FichaPaciente alterar(FichaPaciente ficha);
  public List<FichaPaciente> buscarPorNome(String nome);
  public FichaPaciente recuperarPeloId(Integer id);
  public boolean excluir(Integer id);
}
