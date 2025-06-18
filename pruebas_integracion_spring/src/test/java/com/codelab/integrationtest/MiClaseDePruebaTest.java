package com.codelab.integrationtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class MiClaseDePruebaTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private PaisService paisService;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void holaMundoTest() throws Exception {
        String nombre = "Mundo";
        this.mockMvc.perform(get("/api/pais-service/hola/{nombre}", nombre))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Hola " + nombre));
    }

    @Test
    public void buscarPaisTest() throws Exception {
        Pais miPais = new Pais("Japon", "Tokio", "Asia");
        miPais = paisService.save(miPais);

        this.mockMvc.perform(get("/api/pais-service/paises/{id}", miPais.getId()))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.pais", is(miPais.getPais())));

        paisService.delete(miPais);
    }
}
