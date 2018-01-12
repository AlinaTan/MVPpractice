package alina.mvppractice.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Epistulis on 10/1/2018.
 */

public interface PokemonClient {

    @GET("/api/v2/pokemon/{id}/")
    Call<Pokemon> nameOfPokemon(@Path("id")int id);
}
