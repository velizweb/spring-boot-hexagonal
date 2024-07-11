package com.service.vb.infraestructure.adapters.output.clientPersistence.mapper;

import com.service.vb.domain.model.Client;
import com.service.vb.infraestructure.adapters.output.clientPersistence.entity.ClientEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientPersistenceMapper {
    ClientEntity toClientEntity(Client client);
    Client toClient(ClientEntity entity);
    List<Client> toClientList(List<ClientEntity> entities);
}
