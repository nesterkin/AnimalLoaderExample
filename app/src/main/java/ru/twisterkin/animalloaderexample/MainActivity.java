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

    private TextView mSpecies;
    private TextView mName;
    private TextView mAge;
    private Button mRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpecies = (TextView) findViewById(R.id.species_text_view);
        mName = (TextView) findViewById(R.id.name_text_view);
        mAge = (TextView) findViewById(R.id.age_text_view);
        mRefresh = (Button) findViewById(R.id.refresh_button);

        getSupportLoaderManager().initLoader(LOADER_ID, null, new AnimalLoaderCallbacks());

        mRefresh.setOnClickListener(new View.OnClickListener() {
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
            mSpecies.setText(data.getSpecies());
            mName.setText(data.getName());
            mAge.setText(data.getAge());
        }

        @Override
        public void onLoaderReset(Loader<Animal> loader) {
        }
    }
}
