package br.com.Tramas3030.car_catalog.exceptions;

public class CompanyFoundException extends RuntimeException{

    public CompanyFoundException() {
        super("Company already exists");
    }

}
