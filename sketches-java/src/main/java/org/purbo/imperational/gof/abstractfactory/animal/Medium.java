package org.purbo.imperational.gof.abstractfactory.animal;

/**
 * Medium in/on which animals move.
 */
public interface Medium {

    /**
     * Representing how a medium may influence the way an animal moves through it.
     *
     * @param animal animal that moves
     */
    void letAnimalMovesThrough(Animal animal);

}
