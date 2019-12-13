package com.goulart.market.services;

import java.util.Optional;

import com.goulart.market.domain.Cliente;
import com.goulart.market.repositories.ClienteRepository;
import com.goulart.market.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente find(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id));
    }
    
}