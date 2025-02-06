package com.restaurant.client.menuservice.exception;

public class MenuNotFoundException extends Exception {

    public MenuNotFoundException(String message) {
        super(message);
    }

    public MenuNotFoundException(int number) {
        super(String.format("Total menu: %s, any menu not ready yet", number));
    }
}
