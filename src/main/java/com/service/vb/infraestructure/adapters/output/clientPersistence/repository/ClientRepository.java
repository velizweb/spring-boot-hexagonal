package com.service.vb.infraestructure.adapters.output.clientPersistence.repository;

import com.service.vb.infraestructure.adapters.output.clientPersistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository  extends JpaRepository<ClientEntity, Long> {
}
