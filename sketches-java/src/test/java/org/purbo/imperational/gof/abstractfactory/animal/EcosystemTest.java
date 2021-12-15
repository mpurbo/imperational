package org.purbo.imperational.gof.abstractfactory.animal;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.purbo.imperational.gof.abstractfactory.animal.FunctionalEcosystem.*;

public class EcosystemTest {

    static final Position birdInitialPosition = new Position(12, 12);
    static final Position fishInitialPosition = new Position(12, 8);
    static final Position dogInitialPosition = new Position(8, 12);

    static final Position disasterLocation = new Position(10, 10);

    void assertPositions(List<Position> positions) {
        assertEquals(positions.get(0).getX(), 58);
        assertEquals(positions.get(0).getY(), 26);
        assertEquals(positions.get(1).getX(), 52);
        assertEquals(positions.get(1).getY(), -32);
        assertEquals(positions.get(2).getX(), 64);
        assertEquals(positions.get(2).getY(), -44);
    }

    @Test
    void testImperative() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ImperativeEcosystem ecosystem = new ImperativeEcosystem(List.of(
                AnimalFactory.createAnimal(Bird.class, Air.class, birdInitialPosition),
                AnimalFactory.createAnimal(Fish.class, Water.class, fishInitialPosition),
                AnimalFactory.createAnimal(Dog.class, Earth.class, dogInitialPosition)
        ));
        ecosystem.onNaturalDisaster(disasterLocation);
        List<Animal> animals = ecosystem.getAnimals();

        assertPositions(animals.stream().map(Animal::getPosition).toList());
    }

    @Test
    void testFunctional() {
        assertPositions(Stream
                .of(
                        animal(bird(), birdInitialPosition),
                        animal(fish(), fishInitialPosition),
                        animal(dog(), dogInitialPosition)
                )
                .map(f -> f.apply(disasterLocation))
                .toList());
    }

}
