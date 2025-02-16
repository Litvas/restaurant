package com.restaurant.client.clientservice.services;

import com.restaurant.client.clientservice.domain.Client;

public interface ClientService<T> {

    T getClientByInnerId(String innerId);

    T createClient(Client client);
}
