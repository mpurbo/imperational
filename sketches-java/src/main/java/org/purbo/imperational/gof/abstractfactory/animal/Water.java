package org.purbo.imperational.gof.abstractfactory.animal;

public class Water implements Medium {

    @Override
    public void letAnimalMovesThrough(Animal animal) {
        Position position = animal.getPosition();
        // do something to the animal, e.g. resistance or something.
        animal.setPosition(new Position(position.getX() + 5, position.getY() - 5));
    }

}