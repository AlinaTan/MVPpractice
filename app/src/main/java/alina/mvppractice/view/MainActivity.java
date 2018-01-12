package alina.mvppractice.view;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import alina.mvppractice.IMain;
import alina.mvppractice.R;
import alina.mvppractice.model.Pokemon;
import alina.mvppractice.presenter.PokeManager;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements IMain.View {

    private Button sendRequest;
    private EditText idInput;
    private TextView pokemonName;

    private IMain.Presenter mPresenter;

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
                sendRequest.setEnabled(false);
                pokemonName.setText("Waiting for response...");

                getPresenter().requestCheckVersionThenForceUpdate(Integer.parseInt(idInput.getText().toString()));
            }
        });
    }

    @Override
    public void returnResponseToActivity(Response<Pokemon> response) {

        pokemonName.setText(response.body().getPokemonName());
        sendRequest.setEnabled(true);
    }

    private IMain.Presenter getPresenter(){

        if (mPresenter == null) {
            mPresenter = new PokeManager(MainActivity.this);
        }

        return mPresenter;
    }
}
