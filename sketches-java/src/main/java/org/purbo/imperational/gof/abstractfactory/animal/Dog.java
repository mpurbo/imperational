package org.purbo.imperational.gof.abstractfactory.animal;

public class Dog extends AbstractAnimal {

    @Override
    public void runAwayFrom(Position position) {
        super.runAwayFrom(position);
        jumpAway(position);
    }

    private void jumpAway(Position fromPosition) {
        Position direction = this.position.relativeTo(fromPosition).direction();
        this.position.setX(position.getX() + (Constants.MAGIC_NUMBER_UNIT_PER_JUMP * direction.getX()));
        this.position.setY(position.getY() + (Constants.MAGIC_NUMBER_UNIT_PER_JUMP * direction.getY()));
    }

    @Override
    public boolean isSafeFrom(Position position) {
        return Position.distance(this.position, position) > 200;
    }

}
