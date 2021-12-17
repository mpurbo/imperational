package org.purbo.imperational.gof.abstractfactory.animal;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.purbo.imperational.gof.abstractfactory.animal.FunctionalEcosystemJava.*;

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
        ImperativeEcosystemJava ecosystem = new ImperativeEcosystemJava(List.of(
                BirdFactory.create(birdInitialPosition),
                FishFactory.create(fishInitialPosition),
                DogFactory.create(dogInitialPosition)
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
