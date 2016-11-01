package com.company;

/**
 * Created by veron on 01.11.2016.
 */
public interface ICarFactory {
    ICarBody createCarBody();
    ISalon createSalon();
    IEngine createEngine();
}


