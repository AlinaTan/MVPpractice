package alina.mvppractice.view;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import alina.mvppractice.R;
import alina.mvppractice.presenter.PokeManager;

public class MainActivity extends AppCompatActivity {

    private Button sendRequest;
    private EditText idInput;
    private TextView pokemonName;

    public String requestedPokemonName;

    PokeManager pokeManager = new PokeManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Initialise Views */
        sendRequest = (Button) findViewById(R.id.sendRequest);
        idInput = (EditText) findViewById(R.id.idInput);
        pokemonName = (TextView) findViewById(R.id.pokemonName);

        sendRequest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pokeManager.requestPokemon(Integer.parseInt(idInput.getText().toString()));
                Toast.makeText(getApplicationContext(), "Pokemon Sent!", Toast.LENGTH_SHORT).show();

                if (pokeManager.responseFailure){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }

                else{
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //Need to get the name from the PokeManager
                            pokemonName.setText("name");
                        }
                    }, 200);
                }
            }
        });



    }




}
