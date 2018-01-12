package alina.mvppractice.presenter;

/**
 * Created by Su Ping Alina Tan on 12/1/2018.
 */

public class ResponseHandler {

    private static volatile ResponseHandler instance;
    private String response;

    private ResponseHandler() {}

    public static ResponseHandler getInstance() {
        return instance;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }


}


