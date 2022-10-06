package com.joel.mspurchase.controllers.exception;

public class PersonNotFoundException  extends  EntityNotFoundException{

    public PersonNotFoundException(String message) {
        super(message);
    }

    public PersonNotFoundException(Long id) {
        this(String.format("There is no person with id: %s in the database!", id));
    }
}
