package org.purbo.imperational.gof.abstractfactory.animal;

import java.lang.reflect.InvocationTargetException;

public class Bird extends AbstractAnimal {

    @Override
    public void runAwayFrom(Position position) {
        super.runAwayFrom(position);
        flapWingsAway(position);
    }

    private void flapWingsAway(Position fromPosition) {
        Position direction = this.position.relativeTo(fromPosition);
        this.position.setX(position.getX() + (Constants.MAGIC_NUMBER_UNIT_PER_WINGS_FLAP * direction.getX()));
        this.position.setY(position.getY() + (Constants.MAGIC_NUMBER_UNIT_PER_WINGS_FLAP * direction.getY()));
    }

    @Override
    public boolean isSafeFrom(Position position) {
        return distance(this.position, position) > 100;
    }

}
