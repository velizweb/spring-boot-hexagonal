package com.service.vb.infraestructure.adapters.output.clientPersistence;

import com.service.vb.application.ports.output.ClientOutputPort;
import com.service.vb.domain.model.Client;
import com.service.vb.infraestructure.adapters.output.clientPersistence.mapper.ClientPersistenceMapper;
import com.service.vb.infraestructure.adapters.output.clientPersistence.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class ClientOutputAdapter implements ClientOutputPort {

    private final ClientRepository repository;

    private final ClientPersistenceMapper mapper;

    @Override
    public Optional<Client> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toClient);
    }

    @Override
    public List<Client> findAll() {
        return mapper.toClientList(repository.findAll());
    }

    @Override
    public Client save(Client client) {
        return mapper.toClient(repository.save(mapper.toClientEntity(client)));
    }

    @Override
    public void deteleById(Long id) {
        repository.deleteById(id);
    }
}
