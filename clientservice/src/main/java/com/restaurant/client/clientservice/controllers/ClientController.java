package com.restaurant.client.clientservice.controllers;

import com.restaurant.client.clientservice.domain.Client;
import com.restaurant.client.clientservice.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<Object> getClientByInnerId(@RequestParam(required = true) String innerId) {
        return ResponseEntity.ok().body(Optional.ofNullable(clientService.getClientByInnerId(innerId)).orElse("Not found"));
    }

    @PostMapping
    public ResponseEntity<Object> createClient(@RequestBody Client client){
        return ResponseEntity.ok().body(clientService.createClient(client));
    }

}
