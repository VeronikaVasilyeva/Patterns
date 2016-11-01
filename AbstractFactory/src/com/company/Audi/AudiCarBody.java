package com.company.Audi;

import com.company.ICarBody;

/**
 * Created by veron on 01.11.2016.
 */
public class AudiCarBody implements ICarBody {
    public String name = "Кузов Audi";

    @Override
    public String getName() {
        return name;
    }
}
