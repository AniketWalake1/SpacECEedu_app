package com.spacECE.spaceceedu.VideoLibrary;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.spacECE.spaceceedu.R;
import com.spacECE.spaceceedu.Utils.UsefulFunctions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoLibrary_Activity_SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        VideoLibrary_Activity.topicList.clear();
        VideoLibrary_Activity.freeTopicList.clear();
        VideoLibrary_Activity.paidTopicList.clear();
        VideoLibrary_Activity.trendingTopicList.clear();
        VideoLibrary_Activity.recentTopicList.clear();


        GetLists getLists = new GetLists();
        getLists.execute();


    }


    class GetLists extends AsyncTask<String, Void, JSONObject> {
        final private JSONObject[] apiCall = {null};

        @Override
        protected JSONObject doInBackground(String... strings) {

            try {

                apiCall[0] = UsefulFunctions.UsingGetAPI("http://43.205.45.96/SpacTube/api_all.php?uid=1&type=all");

                JSONArray jsonArray = apiCall[0].optJSONArray("data");
                JSONArray trendingJsonArray = apiCall[0].optJSONArray("data_trending");
                JSONArray recentJsonArray = apiCall[0].optJSONArray("data_recent");

                try {
                    if(jsonArray!=null) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject response_element = new JSONObject(String.valueOf(jsonArray.getJSONObject(i)));

                            Topic newTopic = new Topic(response_element.getString("status"),
                                    response_element.getString("title"),
                                    response_element.getString("v_id"),
                                    response_element.getString("filter"),
                                    response_element.getString("length"),
                                    response_element.getString("v_url"),
                                    response_element.getString("v_date"),
                                    response_element.getString("v_uni_no"),
                                    response_element.getString("v_desc"),
                                    response_element.getString("cntlike"),
                                    response_element.getString("cntdislike"),
                                    response_element.getString("views"),
                                    response_element.getString("cntcomment"));

                            VideoLibrary_Activity.topicList.add(newTopic);
                            if (response_element.getString("status").equalsIgnoreCase("created")) {
                                VideoLibrary_Activity.paidTopicList.add(newTopic);
                            } else {
                                VideoLibrary_Activity.freeTopicList.add(newTopic);
                            }
                        }
                    }

                    if(recentJsonArray!=null) {
                        for (int i = 0; i < recentJsonArray.length(); i++) {

                            JSONObject response_element = new JSONObject(String.valueOf(recentJsonArray.getJSONObject(i)));

                            Topic newTopic = new Topic(response_element.getString("status"),
                                    response_element.getString("title"),
                                    response_element.getString("v_id"),
                                    response_element.getString("filter"),
                                    response_element.getString("length"),
                                    response_element.getString("v_url"),
                                    response_element.getString("v_date"),
                                    response_element.getString("v_uni_no"),
                                    response_element.getString("v_desc"),
                                    response_element.getString("cntlike"),
                                    response_element.getString("cntdislike"),
                                    response_element.getString("views"),
                                    response_element.getString("cntcomment"));

                            VideoLibrary_Activity.recentTopicList.add(newTopic);
                        }
                    }


                    if(trendingJsonArray!=null) {
                        for (int i = 0; i < trendingJsonArray.length(); i++) {

                            JSONObject response_element = new JSONObject(String.valueOf(trendingJsonArray.getJSONObject(i)));

                            Topic newTopic = new Topic(response_element.getString("status"),
                                    response_element.getString("title"),
                                    response_element.getString("v_id"),
                                    response_element.getString("filter"),
                                    response_element.getString("length"),
                                    response_element.getString("v_url"),
                                    response_element.getString("v_date"),
                                    response_element.getString("v_uni_no"),
                                    response_element.getString("v_desc"),
                                    response_element.getString("cntlike"),
                                    response_element.getString("cntdislike"),
                                    response_element.getString("views"),
                                    response_element.getString("cntcomment"));

                            VideoLibrary_Activity.topicList.add(newTopic);
                            VideoLibrary_Activity.trendingTopicList.add(newTopic);
                        }
                    }

                } catch (JSONException jsonException) {
                    jsonException.printStackTrace();
                    Log.i("JSON Object : ", "Key not found");
                }
                VideoLibrary_Activity.ArrayDownloadCOMPLETED[0] = true;
                Log.i("VIDEOS:::::", VideoLibrary_Activity.topicList.toString());

                Intent intent = new Intent(getApplicationContext(), VideoLibrary_Activity.class);
                startActivity(intent);
                finish();

                return null;
            } catch (RuntimeException runtimeException) {
                Log.i("RUNTIME EXCEPTION:::", "Server did not respons");
            }
            return null;
        }
    }

}
