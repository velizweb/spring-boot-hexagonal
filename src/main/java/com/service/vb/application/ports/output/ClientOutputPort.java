package com.service.vb.application.ports.output;

import com.service.vb.domain.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientOutputPort {
    Optional<Client> findById(Long id);
    List<Client> findAll();
    Client save(Client client);
    void deteleById(Long id);
}
