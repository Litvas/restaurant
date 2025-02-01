package com.restaurant.client.clientservice.repositories;

import com.restaurant.client.clientservice.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client getClientByInnerId(String innerId);

}
