package com.spacECE.spaceceedu.VideoLibrary;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spacECE.spaceceedu.ApiFunctions;
import com.spacECE.spaceceedu.R;
import com.spacECE.spaceceedu.VideoLibrary.Topic;
import com.spacECE.spaceceedu.VideoLibrary.TopicActivity;
import com.spacECE.spaceceedu.VideoLibrary.VideoLibrary_RecyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class VideoLibrary_Free extends Fragment {

    ArrayList<Topic> list;

    private RecyclerView recyclerView;
    VideoLibrary_RecyclerViewAdapter.RecyclerViewClickListener listener;
    String account_id="2";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_video_library__free, container, false);

        list = new ArrayList<>(VideoLibrary_Activity.freeTopicList);
//        Bundle extras = getIntent().getExtras();
//        if(extras!= null){account_id=extras.getString("account_id");}

        recyclerView= v.findViewById(R.id.VL_free_RecycleView);
        while(true) {
            if(VideoLibrary_Activity.ArrayDownloadCOMPLETED[0]) {
                setAdapter(list);
                return v;
            }
        }
    }
    private void setAdapter(ArrayList<Topic> myList) {
        Log.i("SetAdapter:","Working");
        setOnClickListener();
        VideoLibrary_RecyclerViewAdapter adapter = new VideoLibrary_RecyclerViewAdapter(myList,listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        Log.i("Adapter", "Executed");
    }

    private void setOnClickListener() {
        listener = new VideoLibrary_RecyclerViewAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getContext(), TopicActivity.class);
                intent.putExtra("acocunt_id",account_id);
                intent.putExtra("topic_name", list.get(position).getTitle());
                intent.putExtra("v_url", list.get(position).getV_URL());
                intent.putExtra("discrp", list.get(position).getDesc());
                intent.putExtra("status",list.get(position).getStatus());
                intent.putExtra("v_id",list.get(position).getV_id());
                startActivity(intent);
            }
        };
    }

}