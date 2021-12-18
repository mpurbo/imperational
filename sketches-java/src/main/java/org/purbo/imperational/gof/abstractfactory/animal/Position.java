package org.purbo.imperational.gof.abstractfactory.animal;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * "Direction" of this position relative to another position.
     *
     * @param anotherPosition The other position for reference.
     * @return
     */
    public Position relativeTo(Position anotherPosition) {
        return new Position(x - anotherPosition.x, y - anotherPosition.y);
    }

    /**
     * Only meaningful when called for the result of {@link #relativeTo(Position)}.
     *
     * @return
     */
    public Position direction() {
        return new Position(x/Math.abs(x), y/Math.abs(y));
    }

    /**
     * Utility function to find the distance between to position.
     */
    public static int distance(Position position1, Position position2) {
        int deltax = position1.getX() - position2.getX();
        int deltay = position1.getY() - position2.getY();
        return (deltax * deltax) + (deltay * deltay);
    }
}
