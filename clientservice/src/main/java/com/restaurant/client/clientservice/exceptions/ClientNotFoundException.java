package com.restaurant.client.clientservice.exceptions;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(String innerId) {
        super(String.format("Client with innerId %s not found in system", innerId));
    }
}
