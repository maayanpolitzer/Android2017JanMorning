package com.maayanpolitzer.whatsapp.connections;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Handler;

import com.maayanpolitzer.whatsapp.infrastructure.BaseThread;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by maayanpolitzer on 16/05/2017.
 */

public class RequestThread extends BaseThread {

    private static final String ACTION = "action";

    private RequestMethod method;
    private RequestAction action;
    private JSONObject data;
    private Callback listener;
    private Handler handler;
    private Context context;

    public RequestThread(Context context, RequestMethod method, RequestAction action, JSONObject data, Callback listener){
        this.context = context;
        this.method = method;
        this.action = action;
        this.data = data;
        this.listener = listener;
        handler = new Handler();
    }

    @Override
    public void run() {
        HttpURLConnection connection = null;
        if(!isNetworkAvailable()){
            listener.onFailure("No internet connection, please try again later.");
            return;
        }
        try {
            URL url = new URL(SERVER_IP);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestMethod(method.name());
            connection.setDoOutput(true);
            connection.setDoInput(true);

            data.put(ACTION, action.name());

            OutputStream out = connection.getOutputStream();
            out.write(data.toString().getBytes());

            InputStream in = connection.getInputStream();
            StringBuilder sb = new StringBuilder();

            /*
            byte[] buffer = new byte[1024];
            int actuallyRead;
            while((actuallyRead = in.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, actuallyRead));
            }
            */

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while((line = reader.readLine()) != null) {
                sb.append(line);
            }

            JSONObject object = new JSONObject(sb.toString());

            updateSuccess(object);

        } catch (MalformedURLException e) {
            updateError("URL syntax error");
        } catch (IOException e) {
            updateError("Server problem, please try again later.");
        } catch (JSONException e) {
            updateError("Problem converting String to JsonObject");
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
    /*
    private void update(final Object object, final boolean success){
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(success){
                    listener.onSuccess((JSONObject) object);
                }else{
                    listener.onFailure((String) object);
                }
            }
        });
    }
    */

    private void updateError(final String error){
        handler.post(new Runnable() {
            @Override
            public void run() {
                listener.onFailure(error);
            }
        });
    }

    private void updateSuccess(final JSONObject object){
        handler.post(new Runnable() {
            @Override
            public void run() {
                listener.onSuccess(object);
            }
        });
    }

    public enum RequestMethod {
        POST, GET
    }

    public enum RequestAction {
        LOGIN, REGISTER, GET_USERS, GET_MESSAGES, SEND_MESSAGE
    }

    public interface Callback {
        void onSuccess(JSONObject data);
        void onFailure(String error);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

}
