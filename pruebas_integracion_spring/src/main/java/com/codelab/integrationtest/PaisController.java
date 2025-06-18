package com.codelab.integrationtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/pais-service")  // Esto es importante para que coincida con tu test
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping("/hola/{nombre}")
    public String hola(@PathVariable String nombre) {
        return "Hola " + nombre;
    }

    @GetMapping("/paises/{id}")
    public ResponseEntity<Pais> obtenerPais(@PathVariable Long id) {
        return paisService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
