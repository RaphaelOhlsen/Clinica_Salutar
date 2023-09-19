package dev.mocad.salutar;

import dev.mocad.salutar.model.FichaPaciente;
import dev.mocad.salutar.service.ficha.IFichaService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class FichaTests {

  @Autowired
  IFichaService service;

  private FichaPaciente createFicha() {
    FichaPaciente f = new FichaPaciente();
    f.setNomePaciente("Raphael");
    service.cadastrar(f);
    return f;
  }

  @Test
  public void shouldCreateFicha() {
//    FichaPaciente f = new FichaPaciente();
//    f.setNomePaciente("Raphael");
//    FichaPaciente res = service.cadastrar(f);
    FichaPaciente res = this.createFicha();
    assertTrue(res != null && res.getAtivo() == 1 && res.getUuid() != null);
  }

  @Test
  public void shouldDeleFicha() {
//    FichaPaciente f = new FichaPaciente();
//    f.setNomePaciente("Raphael");
//    FichaPaciente res = service.cadastrar(f);
    this.createFicha();
    assertTrue(service.excluir(1));
  }

  @Test
  public void shoulNotDelete() {
    assertFalse(service.excluir(100));
  }

  @Test
  void shoulReturnSeveralFichas() {
    List<FichaPaciente> lista = service.buscarPorNome("a");
    assertTrue(lista.size() > 0);
  }

  @Test
  void shouldNotFincFicha() {
    List<FichaPaciente> lista = service.buscarPorNome("x");
    assertEquals(0, lista.size());}
}
