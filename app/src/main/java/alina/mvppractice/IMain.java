package alina.mvppractice;

import alina.mvppractice.model.Pokemon;
import retrofit2.Response;

/**
 * Created by kins on 1/12/2018.
 */

public interface IMain {

    interface View {
        void returnResponseToActivity(Response<Pokemon> response);
    }

    interface Presenter {
        void requestCheckVersionThenForceUpdate(int id);
    }
}
