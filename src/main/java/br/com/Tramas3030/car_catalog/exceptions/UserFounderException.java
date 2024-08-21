package br.com.Tramas3030.car_catalog.exceptions;

public class UserFounderException extends RuntimeException {

    public UserFounderException() {
        super("Usuário já existe");
    }

}
