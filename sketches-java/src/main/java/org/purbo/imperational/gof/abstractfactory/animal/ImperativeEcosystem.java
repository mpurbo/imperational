package org.purbo.imperational.gof.abstractfactory.animal;

import java.util.List;

/**
 * Ecosystem is the "client" of Abstract Factory
 */
public class ImperativeEcosystem {

    List<Animal> animals;

    public ImperativeEcosystem(List<Animal> animals) {
        this.animals = animals;
    }

    /**
     * When a natural disaster happens, all animals run away until they're all safe.
     *
     * @param whereItHappens the position where the disaster happens
     */
    public void onNaturalDisaster(Position whereItHappens) {
        // all animals run away from where the disaster happens until they're safe
        boolean allSafe;
        do {
            allSafe = animalsRunFrom(whereItHappens);
        } while (!allSafe);
    }

    private boolean animalsRunFrom(Position whereItHappens) {
        boolean allSafe = true;
        for (Animal animal : animals) {
            if (!animal.isSafeFrom(whereItHappens)) {
                animal.runAwayFrom(whereItHappens);
                allSafe = false;
            }
        }
        return allSafe;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
