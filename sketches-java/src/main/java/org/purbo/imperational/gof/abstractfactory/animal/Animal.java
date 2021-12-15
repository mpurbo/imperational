package org.purbo.imperational.gof.abstractfactory.animal;

import java.lang.reflect.InvocationTargetException;

public interface Animal {

    void runAwayFrom(Position position);
    boolean isSafeFrom(Position position);

    Position getPosition();
    void setPosition(Position position);


    public <T extends Medium> void initMedium(Class<T> clazz)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
    Medium getMedium();

}
