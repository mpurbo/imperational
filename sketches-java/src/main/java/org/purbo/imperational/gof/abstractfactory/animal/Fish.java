package org.purbo.imperational.gof.abstractfactory.animal;

public class Fish extends AbstractAnimal {

    @Override
    public void runAwayFrom(Position position) {
        super.runAwayFrom(position);
        swimAway(position);
    }

    private void swimAway(Position fromPosition) {
        Position direction = this.position.relativeTo(fromPosition);
        this.position.setX(position.getX() + (Constants.MAGIC_NUMBER_UNIT_PER_STROKE * direction.getX()));
        this.position.setY(position.getY() + (Constants.MAGIC_NUMBER_UNIT_PER_STROKE * direction.getY()));
    }

    @Override
    public boolean isSafeFrom(Position position) {
        return distance(this.position, position) > 75;
    }

}
