package com.company.Audi;

import com.company.BMW.BMWCarBody;
import com.company.BMW.BMWEngine;
import com.company.BMW.BMWSalon;
import com.company.ICarBody;
import com.company.ICarFactory;
import com.company.IEngine;
import com.company.ISalon;

/**
 * Created by veron on 01.11.2016.
 */
public class AudiFactory implements ICarFactory {
    @Override
    public ICarBody createCarBody() {
        return new AudiCarBody();
    }

    @Override
    public ISalon createSalon() {
        return new AudiSalon();
    }

    @Override
    public IEngine createEngine() {
        return new AudiEngine();
    }
}