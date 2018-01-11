package alina.mvppractice.presenter;


import android.content.Intent;

import java.util.List;

import alina.mvppractice.model.PokemonClient;
import alina.mvppractice.model.Pokemon;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alina on 9/1/2018.
 */

public class PokeManager {
    public Boolean responseFailure = false;
    public Pokemon pokemon;


    public void requestPokemon(int id){

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        PokemonClient client = retrofit.create(PokemonClient.class);
        Call<Pokemon> call = client.typesForPokemon(id);

        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                //The problem is here
                /*Intent resultIntent = new Intent();
                resultIntent.putExtra("name", response.body().getPokemonName());*/
                //pokemon = response.body();
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                responseFailure = true;
            }
        });
    }








}
