package ru.twisterkin.animalloaderexample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nesterkin Alexander
 */

public class AnimalGenerator {
    public static List<Animal> provideAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", "Maxim", 12));
        animals.add(new Animal("Dog", "Alexey", 11));
        animals.add(new Animal("Shark", "Dmitry", 7));
        animals.add(new Animal("Wolf", "Sergey", 4));
        animals.add(new Animal("Gorilla", "Nickolay", 8));
        animals.add(new Animal("Kangaroo", "Konstantin", 2));
        animals.add(new Animal("Lion", "Egor", 17));
        animals.add(new Animal("Penguin", "Fedor", 45));
        animals.add(new Animal("Falcon", "Artem", 21));
        animals.add(new Animal("Hawk", "Mihail", 18));
        return animals;
    }
}
