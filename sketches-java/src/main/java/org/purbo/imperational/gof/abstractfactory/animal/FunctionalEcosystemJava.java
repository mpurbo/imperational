package org.purbo.imperational.gof.abstractfactory.animal;

import java.util.function.Function;
import java.util.function.BiFunction;

public class FunctionalEcosystemJava {

    /**
     * A helper to make recursive lambda definition possible.
     *
     * @param <I>
     */
    private static class Recursive<I> {
        public I func;
    }

    /**
     * Definition of an animal that can run/move in a medium, and be at a safe place.
     *
     * @param run       movement of the animal
     * @param medium    how the medium in which the animal moves influence the movement.
     * @param safeCheck a way to check whether an animal is in a safe place
     * @return a function that represent an animal
     */
    public static BiFunction<Position, Position, Position> animal(
            BiFunction<Position, Position, Position> run,
            Function<Position, Position> medium,
            BiFunction<Position, Position, Boolean> safeCheck) {
        Recursive<BiFunction<Position, Position, Position>> recursiveAnimal = new Recursive<>();
        recursiveAnimal.func = (fromPosition, currentPosition) ->
                safeCheck.apply(fromPosition, currentPosition) ?
                        currentPosition :
                        recursiveAnimal.func.apply(
                                fromPosition,
                                run.apply(fromPosition, medium.apply(currentPosition)));
        return recursiveAnimal.func;
    }

    public static Function<Position, Position> animal(
            BiFunction<Position, Position, Position> animalInstance,
            Position initialPosition) {
        return (position) -> animalInstance.apply(position, initialPosition);
    }

    public static BiFunction<Position, Position, Position> bird() {
        return animal(
                (fromPosition, currentPosition) -> {
                    Position direction = currentPosition.relativeTo(fromPosition);
                    return new Position(
                            currentPosition.getX() + (Constants.MAGIC_NUMBER_UNIT_PER_WINGS_FLAP * direction.getX()),
                            currentPosition.getY() + (Constants.MAGIC_NUMBER_UNIT_PER_WINGS_FLAP * direction.getY())
                    );
                },
                (position) -> new Position(position.getX() + 1, position.getY() - 1),
                (fromPosition, position) -> distance(position, fromPosition) > 100
        );
    }

    public static BiFunction<Position, Position, Position> dog() {
        return animal(
                (fromPosition, currentPosition) -> {
                    Position direction = currentPosition.relativeTo(fromPosition);
                    return new Position(
                            currentPosition.getX() + (Constants.MAGIC_NUMBER_UNIT_PER_JUMP * direction.getX()),
                            currentPosition.getY() + (Constants.MAGIC_NUMBER_UNIT_PER_JUMP * direction.getY())
                    );
                },
                (position) -> new Position(position.getX() + 3, position.getY() - 3),
                (fromPosition, position) -> distance(position, fromPosition) > 200
        );
    }

    public static BiFunction<Position, Position, Position> fish() {
        return animal(
                (fromPosition, currentPosition) -> {
                    Position direction = currentPosition.relativeTo(fromPosition);
                    return new Position(
                            currentPosition.getX() + (Constants.MAGIC_NUMBER_UNIT_PER_STROKE * direction.getX()),
                            currentPosition.getY() + (Constants.MAGIC_NUMBER_UNIT_PER_STROKE * direction.getY())
                    );
                },
                (position) -> new Position(position.getX() + 5, position.getY() - 5),
                (fromPosition, position) -> distance(position, fromPosition) > 75
        );
    }

    // reasoning process how to construct functinal version

    /*
    public static Position bird(Position fromPosition, Position currentPosition) {
        if (birdSafeCheck(fromPosition, currentPosition)) {
            return currentPosition;
        } else {
            return bird(fromPosition, birdRun(fromPosition, airResistance(currentPosition)));
        }
    }

    public static Position birdRun(Position fromPosition, Position currentPosition) {
        Position direction = currentPosition.relativeTo(fromPosition);
        return new Position(
                currentPosition.getX() + (Constants.MAGIC_NUMBER_UNIT_PER_WINGS_FLAP * direction.getX()),
                currentPosition.getY() + (Constants.MAGIC_NUMBER_UNIT_PER_WINGS_FLAP * direction.getY())
        );
    }

    public static Position airResistance(Position position) {
        return new Position(position.getX() + 1, position.getY() - 1);
    }

    public static Boolean birdSafeCheck(Position fromPosition, Position position) {
        return distance(position, fromPosition) > 100;
    }

     */

    public static int distance(Position position1, Position position2) {
        int deltax = position1.getX() - position2.getX();
        int deltay = position1.getY() - position2.getY();
        return (deltax * deltax) + (deltay * deltay);
    }

    public static void main(String[] args) {

        Position birdSafePosition = animal(bird(), new Position(12, 12)).apply(new Position(10, 10));
        //Position birdSafePosition = bird().apply(new Position(10, 10), new Position(12, 12));
        System.out.println(birdSafePosition.getX() + "," + birdSafePosition.getY());

        /*
        Position birdSafePosition = bird(new Position(10, 10), new Position(12, 12));
        System.out.println(birdSafePosition.getX() + "," + birdSafePosition.getY());
         */
    }

}
