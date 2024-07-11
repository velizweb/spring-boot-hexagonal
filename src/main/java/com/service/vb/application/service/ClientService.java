package com.service.vb.application.service;

import com.service.vb.application.ports.input.ClientInputPort;
import com.service.vb.application.ports.output.ClientOutputPort;
import com.service.vb.domain.exception.ClientNotFoundException;
import com.service.vb.domain.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService  implements ClientInputPort {

    private final ClientOutputPort clientOutputPort;

    @Override
    public Client findById(Long id) {
        return clientOutputPort.findById(id)
                .orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public List<Client> findAll() {
        return clientOutputPort.findAll();
    }

    @Override
    public Client save(Client client) {
        return clientOutputPort.save(client);
    }

    @Override
    public Client update(Long id, Client client) {
        return clientOutputPort.findById(id)
                .map(resp -> {
                    resp.setFirstname(client.getFirstname());
                    resp.setLastname(client.getLastname());
                    resp.setEmail(client.getEmail());
                    resp.setAddress(client.getAddress());
                    return clientOutputPort.save(resp);
                })
                .orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public void detele(Long id) {
        if(clientOutputPort.findById(id).isEmpty()){
            throw  new ClientNotFoundException();
        }

        clientOutputPort.deteleById(id);
    }
}
