package com.company.BMW;

import com.company.ISalon;

/**
 * Created by veron on 01.11.2016.
 */
public class BMWSalon implements ISalon {
    public String name = "Салон BMW";

    @Override
    public String getName() {
        return name;
    }
}
