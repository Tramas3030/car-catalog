package br.com.Tramas3030.car_catalog.exceptions;

public class CarFoundException extends RuntimeException {
    public CarFoundException() {
        super("This car has already been registered");
    }
}
