package br.com.Tramas3030.car_catalog.exceptions;

public class UserFoundException extends RuntimeException {

    public UserFoundException() {
        super("User already exists");
    }

}
