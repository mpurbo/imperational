package org.purbo.imperational.gof.abstractfactory.animal;

import java.lang.reflect.InvocationTargetException;

public class AnimalFactory {

    public static <T extends Animal, U extends Medium> Animal createAnimal(Class<T> animalClass, Class<U> mediumClass, Position initialPosition)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Animal ret = animalClass.getDeclaredConstructor().newInstance();
        ret.initMedium(mediumClass);
        ret.setPosition(initialPosition);
        return ret;
    }

}
