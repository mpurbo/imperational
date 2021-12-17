package org.purbo.imperational.gof.abstractfactory.animal;

import java.lang.reflect.InvocationTargetException;

/**
 * Representing an animal in an ecosystem.
 */
public interface Animal {

    /**
     * Given a position, this animal is able to move themselves away from it.
     *
     * @param position Position to run away from.
     */
    void runAwayFrom(Position position);

    /**
     * Given a position, this animal is able to decide whether they are within a safe distance from it.
     *
     * @param position Position to evaluate.
     * @return whether this animal is safe from the given position.
     */
    boolean isSafeFrom(Position position);

    /**
     * Getting the current position of this animal.
     */
    Position getPosition();

    /**
     * Setting the position of this animal.
     *
     * @param position
     */
    void setPosition(Position position);

    /**
     * Initialize the medium in/on which this animal moves.
     *
     * @param clazz
     * @param <T>
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public <T extends Medium> void initMedium(Class<T> clazz)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
    Medium getMedium();

}
