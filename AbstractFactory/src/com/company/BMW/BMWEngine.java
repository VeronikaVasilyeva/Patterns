package com.company.BMW;

import com.company.IEngine;

/**
 * Created by veron on 01.11.2016.
 */
public class BMWEngine implements IEngine {
    public String name = "Двигатель BMW";

    @Override
    public String getName() {
        return name;
    }
}
