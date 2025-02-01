package com.restaurant.client.clientservice.services.impl;

import com.restaurant.client.clientservice.domain.Client;
import com.restaurant.client.clientservice.repositories.ClientRepository;
import com.restaurant.client.clientservice.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService<Client> {

    private final ClientRepository clientRepository;

    public Client getClientByInnerId(String innerId) {
        return clientRepository.getClientByInnerId(innerId);
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

}
