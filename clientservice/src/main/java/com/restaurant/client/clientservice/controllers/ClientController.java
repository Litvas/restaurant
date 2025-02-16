package com.restaurant.client.clientservice.controllers;

import com.restaurant.client.clientservice.domain.Client;
import com.restaurant.client.clientservice.dtos.ClientDTO;
import com.restaurant.client.clientservice.services.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
@Validated
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ClientDTO getClientByInnerId(@RequestParam String innerId) {
        return clientService.getClientByInnerId(innerId);
    }

    @PostMapping
    public ClientDTO createClient(@RequestBody @Valid Client client) {
        return clientService.createClient(client);
    }

}
