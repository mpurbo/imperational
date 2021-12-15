package org.purbo.imperational.gof.abstractfactory.animal;

public class Earth implements Medium {

    @Override
    public void letAnimalMovesThrough(Animal animal) {
        Position position = animal.getPosition();
        // do something to the animal, e.g. resistance or something.
        animal.setPosition(new Position(position.getX() + 3, position.getY() - 3));
    }

}
