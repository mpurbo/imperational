package org.purbo.imperational.gof.abstractfactory.animal;

import java.lang.reflect.InvocationTargetException;

public abstract class AbstractAnimal implements Animal {

    /**
     * The current position of the animal.
     */
    protected Position position;

    /**
     * The medium on/in which the animal moves.
     */
    protected Medium medium;

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Medium getMedium() {
        return medium;
    }

    @Override
    public <T extends Medium> void initMedium(Class<T> clazz)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        this.medium = clazz.getDeclaredConstructor().newInstance();
    }

    @Override
    public void runAwayFrom(Position position) {
        this.medium.letAnimalMovesThrough(this);
    }

    public static int distance(Position position1, Position position2) {
        int deltax = position1.getX() - position2.getX();
        int deltay = position1.getY() - position2.getY();
        return (deltax * deltax) + (deltay * deltay);
    }

}
