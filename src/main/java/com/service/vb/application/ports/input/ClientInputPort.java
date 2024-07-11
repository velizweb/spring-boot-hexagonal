package com.service.vb.application.ports.input;

import com.service.vb.domain.model.Client;

import java.util.List;

public interface ClientInputPort {
    Client findById(Long id);
    List<Client> findAll();
    Client save(Client client);
    Client update(Long id, Client client);
    void detele(Long id);
}
