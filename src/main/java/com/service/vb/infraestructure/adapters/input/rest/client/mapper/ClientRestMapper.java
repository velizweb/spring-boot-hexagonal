package com.service.vb.infraestructure.adapters.input.rest.client.mapper;

import com.service.vb.domain.model.Client;
import com.service.vb.infraestructure.adapters.input.rest.client.model.request.ClientCreateRequest;
import com.service.vb.infraestructure.adapters.input.rest.client.model.response.ClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientRestMapper {

    Client toClient(ClientCreateRequest request);

    ClientResponse toClientResponse(Client client);

    List<ClientResponse> toClientResponseList(List<Client> clients);
}
