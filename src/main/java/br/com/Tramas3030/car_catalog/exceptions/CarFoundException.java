package br.com.Tramas3030.car_catalog.exceptions;

public class CarFoundException extends RuntimeException {
    public CarFoundException() {
        super("Carro já cadastrado");
    }
}
