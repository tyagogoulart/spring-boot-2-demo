package com.goulart.market.services;

import java.util.List;
import java.util.Optional;

import com.goulart.market.domain.Categoria;
import com.goulart.market.repositories.CategoriaRepository;
import com.goulart.market.services.exceptions.DataIntegrityException;
import com.goulart.market.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id));
    }

    public Categoria insert(Categoria obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Categoria update(Categoria obj) {
        find(obj.getId());
        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos.");
        }
    }
    
    public List<Categoria> findAll() {  
        return repo.findAll();
    }
}