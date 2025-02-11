package com.restaurant.client.clientservice.services.impl;

import com.restaurant.client.clientservice.domain.Client;
import com.restaurant.client.clientservice.dtos.ClientDTO;
import com.restaurant.client.clientservice.mappers.ClientMapper;
import com.restaurant.client.clientservice.repositories.ClientRepository;
import com.restaurant.client.clientservice.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService<ClientDTO> {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    public ClientDTO getClientByInnerId(String innerId) {
        return clientMapper.toClientDTO(clientRepository.getClientByInnerId(innerId));
    }

    @Override
    public ClientDTO createClient(Client client) {
        return clientMapper.toClientDTO(clientRepository.save(client));
    }

}
