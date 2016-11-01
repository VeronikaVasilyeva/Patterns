package com.company.Audi;

import com.company.ISalon;

/**
 * Created by veron on 01.11.2016.
 */
public class AudiSalon implements ISalon {
    public String name = "Салон Audi";

    @Override
    public String getName() {
        return name;
    }
}
