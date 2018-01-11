package alina.mvppractice.presenter;


import android.widget.Toast;

import java.util.List;

import alina.mvppractice.model.PokemonClient;
import alina.mvppractice.model.PokemonType;
import alina.mvppractice.view.MainActivity;
import alina.mvppractice.view.SuccessfulActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alina on 9/1/2018.
 */

public class PokeManager {

    private String pokemon;
    public List<PokemonType> pokemonTypes;
    public Boolean responseFailure = false;


    public void requestPokemon(String name){
        this.pokemon = name;

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        PokemonClient client = retrofit.create(PokemonClient.class);
        Call<List<PokemonType>> call = client.typesForPokemon(pokemon);

        call.enqueue(new Callback<List<PokemonType>>() {
            @Override
            public void onResponse(Call<List<PokemonType>> call, Response<List<PokemonType>> response) {
                pokemonTypes = response.body();
                responseFailure = false;
            }

            @Override
            public void onFailure(Call<List<PokemonType>> call, Throwable t) {
                responseFailure = true;
            }
        });
    }








}
