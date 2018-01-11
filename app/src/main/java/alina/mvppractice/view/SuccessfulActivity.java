package alina.mvppractice.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import alina.mvppractice.R;
import alina.mvppractice.presenter.PokeManager;
import alina.mvppractice.presenter.PokemonTypeAdapter;

public class SuccessfulActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful);

        /* Initialise Views */
        listView = (ListView) findViewById(R.id.pagination_list);

        // NEED TO TRANSFER INFO FROM THE POKEMANAGER IN MAIN ACTIVITY TO THIS PLACE OVER
        listView.setAdapter(new PokemonTypeAdapter(SuccessfulActivity.this, /* HERE */pokeManager.pokemonTypes));



    }

}
