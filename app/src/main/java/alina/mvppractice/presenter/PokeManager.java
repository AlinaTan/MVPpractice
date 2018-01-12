package alina.mvppractice.presenter;


import android.util.Log;

import alina.mvppractice.IMain;
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

public class PokeManager implements IMain.Presenter {

    private final IMain.View mMainView;

    public PokeManager(IMain.View mMainView) {
        this.mMainView = mMainView;
    }

    @Override
    public void requestCheckVersionThenForceUpdate(int id) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        PokemonClient client = retrofit.create(PokemonClient.class);
        Call<Pokemon> call = client.nameOfPokemon(id);

        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                mMainView.returnResponseToActivity(response);
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.d("tag", "onFailure with " + t.getMessage());
            }
        });
    }
}
