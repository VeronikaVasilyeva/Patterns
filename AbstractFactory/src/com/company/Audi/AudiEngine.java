package com.company.Audi;

import com.company.IEngine;

/**
 * Created by veron on 01.11.2016.
 */
public class AudiEngine implements IEngine {
    public String name = "Двигатель Audi";

    @Override
    public String getName() {
        return name;
    }
}
