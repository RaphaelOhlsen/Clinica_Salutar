package dev.mocad.salutar;

import dev.mocad.salutar.model.FichaPaciente;
import dev.mocad.salutar.service.ficha.IFichaService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class FichaTests {

  @Autowired
  IFichaService service;

  @Test
  public void shouldCreateFicha() {
    FichaPaciente f = new FichaPaciente();
    f.setNomePaciente("Raphael");
    FichaPaciente res = service.cadastrar(f);
    assertTrue(res != null && res.getAtivo() == 1 && res.getUuid() != null);
  }
}
