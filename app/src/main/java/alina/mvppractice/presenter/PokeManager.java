package alina.mvppractice.presenter;


import android.content.Intent;
import android.util.Log;

import java.util.List;

import alina.mvppractice.model.PokemonClient;
import alina.mvppractice.model.Pokemon;
import alina.mvppractice.view.MainActivity;
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
    public MainActivity mainActivity;


    public void requestPokemon(int id){

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        PokemonClient client = retrofit.create(PokemonClient.class);
        Call<Pokemon> call = client.nameOfPokemon(id);

        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {

                ResponseHandler responseHandler = ResponseHandler.getInstance();
                responseHandler.setResponse(response.body().getPokemonName());
                mainActivity.returnResponseToActivity(responseHandler);

                //PokeManager pokeManager = PokeManager.getInstance();

                //mainActivity.returnResponseToActivity(response.body().getPokemonName());
                //Log.d("tag", "response is:" + response.body().getPokemonName());
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                responseFailure = true;
            }
        });
    }

}
