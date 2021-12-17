package org.purbo.imperational.gof.abstractfactory.animal;

import java.lang.reflect.InvocationTargetException;

public class FishFactory {

    public static Animal create(Position initialPosition)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return AnimalFactory.createAnimal(Fish.class, Water.class, initialPosition);
    }

}
