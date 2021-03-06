package com.ridgue.homefood.database.repository.facade;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.http.domain.request.ClientRequest;

import java.util.List;

public interface ClientRepositoryFacade {
    List<ClientEntity> findAll();
    ClientEntity findById(Long id);
    long create(ClientEntity clientEntity);
    ClientEntity updateById(Long id, ClientRequest clientRequest);
    ClientEntity updateTokenById(Long id, String token);
    ClientEntity activate(Long id, String token);
    void deleteById(Long id);
}
