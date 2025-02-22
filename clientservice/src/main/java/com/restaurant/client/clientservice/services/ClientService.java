package com.restaurant.client.clientservice.services;

import com.restaurant.client.clientservice.domain.Client;
import com.restaurant.client.clientservice.dtos.ClientDTO;

public interface ClientService {

    ClientDTO getClientByInnerId(String innerId);

    ClientDTO createClient(Client client);
}
