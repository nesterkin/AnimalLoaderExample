package ru.twisterkin.animalloaderexample;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static int LOADER_ID = 1;

    private TextView mSpeciesTextView;
    private TextView mNameTextView;
    private TextView mAgeTextView;
    private Button mRefreshButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpeciesTextView = (TextView) findViewById(R.id.species_text_view);
        mNameTextView = (TextView) findViewById(R.id.name_text_view);
        mAgeTextView = (TextView) findViewById(R.id.age_text_view);
        mRefreshButton = (Button) findViewById(R.id.refresh_button);

        getSupportLoaderManager().initLoader(LOADER_ID, null, new AnimalLoaderCallbacks());

        mRefreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportLoaderManager().getLoader(LOADER_ID).forceLoad();
            }
        });
    }

    private class AnimalLoaderCallbacks implements LoaderManager.LoaderCallbacks<Animal> {

        @Override
        public Loader<Animal> onCreateLoader(int id, Bundle args) {
            return new AnimalLoader(MainActivity.this);
        }

        @Override
        public void onLoadFinished(Loader<Animal> loader, Animal data) {
            mSpeciesTextView.setText(data.getSpecies());
            mNameTextView.setText(data.getName());
            mAgeTextView.setText(data.getAge());
        }

        @Override
        public void onLoaderReset(Loader<Animal> loader) {
        }
    }
}
