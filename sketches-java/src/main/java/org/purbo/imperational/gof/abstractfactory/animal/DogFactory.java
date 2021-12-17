package org.purbo.imperational.gof.abstractfactory.animal;

import java.lang.reflect.InvocationTargetException;

public class DogFactory {

    public static Animal create(Position initialPosition)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return AnimalFactory.createAnimal(Dog.class, Earth.class, initialPosition);
    }

}
