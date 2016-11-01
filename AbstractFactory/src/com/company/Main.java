package com.company;

import com.company.Audi.AudiFactory;
import com.company.BMW.BMWFactory;

public class Main {

    public static void main(String[] args) {

        System.out.println("===========BMW===========");

        BMWFactory bmwFactory = new BMWFactory();
        PrintCarInfo(bmwFactory);

        System.out.println("============Audi============");

        AudiFactory audiFactory = new AudiFactory();
        PrintCarInfo(audiFactory);
    }

    public static void PrintCarInfo(ICarFactory factory) {
        System.out.println("====Устройсво машины====");

        System.out.println(factory.createEngine().getName());
        System.out.println(factory.createCarBody().getName());
        System.out.println(factory.createSalon().getName());
    }
}
