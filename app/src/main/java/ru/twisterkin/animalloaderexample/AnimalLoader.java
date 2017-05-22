package ru.twisterkin.animalloaderexample;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;
import java.util.Random;

public class AnimalLoader extends AsyncTaskLoader<Animal> {

    private List<Animal> mAnimals;
    private final static Random RANDOM_ANIMAL = new Random();

    public AnimalLoader(Context context) {
        super(context);
        this.mAnimals = AnimalGenerator.provideAnimals();
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public Animal loadInBackground() {
        return mAnimals.get(RANDOM_ANIMAL.nextInt(mAnimals.size()));
    }
}
