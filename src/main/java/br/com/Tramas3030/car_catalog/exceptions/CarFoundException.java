package br.com.Tramas3030.car_catalog.exceptions;

public class CarFoundException extends RuntimeException {
    public CarFoundException() {
        super("A car with the same name and color already exists for this company");
    }
}
