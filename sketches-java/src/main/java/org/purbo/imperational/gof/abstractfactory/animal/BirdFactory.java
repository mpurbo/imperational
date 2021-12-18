package org.purbo.imperational.gof.abstractfactory.animal;

import java.lang.reflect.InvocationTargetException;

public class BirdFactory {

    public static Animal create(Position initialPosition)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return AnimalFactory.createAnimal(Bird.class, Air.class, initialPosition);
    }
}
