package ru.twisterkin.animalloaderexample;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;
import java.util.Random;

/**
 * Created by Nesterkin Alexander
 */

public class AnimalLoader extends AsyncTaskLoader<Animal> {

    private List<Animal> mAnimals;

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
        Random random = new Random();
        return mAnimals.get(random.nextInt(mAnimals.size()));
    }
}
