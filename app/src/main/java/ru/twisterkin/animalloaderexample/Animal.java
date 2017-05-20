package ru.twisterkin.animalloaderexample;

/**
 * Created by Nesterkin Alexander
 */

class Animal {
    private String mSpecies;
    private String mName;
    private int mAge;

    public Animal(String mSpecies, String mName, int age) {
        this.mSpecies = mSpecies;
        this.mName = mName;
        this.mAge = age;
    }

    public String getName() {
        return mName;
    }

    public String getSpecies() {
        return mSpecies;
    }

    public String getAge() {
        return String.valueOf(mAge);
    }
}

