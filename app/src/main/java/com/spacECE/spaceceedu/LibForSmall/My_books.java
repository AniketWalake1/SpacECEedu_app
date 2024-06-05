package com.spacECE.spaceceedu.LibForSmall;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.spacECE.spaceceedu.R;
import com.spacECE.spaceceedu.Utils.UsefulFunctions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class My_books extends AppCompatActivity {

    public static ArrayList<Book> books = new ArrayList<Book>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean[] COMPLETED = {false};
        JSONObject[] apiCall = {null};

        setContentView(R.layout.activity_my_books);

        Thread thread = new Thread(() -> {

            try {
                Log.e( "onCreate:123456789","1234567890");
                apiCall[0] = UsefulFunctions.UsingGetAPI("http://43.205.45.96/ConsultUs/api_user_appoint.php?user=raju%20rastogi");
                try {
                    Log.i("Object Obtained: ", apiCall[0].get("data").toString());
                } catch (JSONException e) {
                    Log.i("API Response:", "Error");
                    e.printStackTrace();
                }

                JSONArray jsonArray = null;
                try {
                    jsonArray = apiCall[0].getJSONArray("data");
                    Log.i("API : ", apiCall[0].toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            } catch (RuntimeException runtimeException) {
                Log.i("RUNTIME EXCEPTION:::", "Server did not respons");
            }
        });

        books.add(new Book("The number system", new Date(), 30));
        Date abc = new Date();
        Log.i("Object", abc.toString());

    }
}
