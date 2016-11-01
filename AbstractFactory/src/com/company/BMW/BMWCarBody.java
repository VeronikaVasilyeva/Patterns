package com.company.BMW;

import com.company.ICarBody;

/**
 * Created by veron on 01.11.2016.
 */
public class BMWCarBody implements ICarBody {
    public String name = "Кузов BMW";

    @Override
    public String getName() {
        return name;
    }
}
