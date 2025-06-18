package com.codelab.integrationtest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    public Pais save(Pais pais) {
        return paisRepository.save(pais);
    }

    public void delete(Pais pais) {
        paisRepository.delete(pais);
    }

    public Optional<Pais> findById(Long id) {
        return paisRepository.findById(id);
    }

}
