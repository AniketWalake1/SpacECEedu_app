package com.spacECE.spaceceedu.VideoLibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.spacECE.spaceceedu.ApiFunctions;
import com.spacECE.spaceceedu.R;

import java.net.URL;
import java.net.URLEncoder;

public class TopicActivity extends AppCompatActivity {

        private YouTubePlayerView youTubePlayerView;

        private Button b_likeVideo;
        private Button b_dislikeVideo;
        private Button b_share;
        private Button b_comment;
        private TextView tv_like;
        private TextView tv_dislike;
        private TextView tv_views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);


            TextView discrip_view = findViewById(R.id.Topic_TextView_Description);
            b_comment= findViewById(R.id.Topics_Button_Comment);
            b_share=findViewById(R.id.Topic_Button_Share);
            b_likeVideo=findViewById(R.id.Topic_Button_LikeVideo);
            b_dislikeVideo= findViewById(R.id.Topic_Button_DislikeVideo);
            tv_dislike=findViewById(R.id.Topic_TextView_dislikeCount);
            tv_like=findViewById(R.id.Topic_TextView_likeCount);
            tv_views = findViewById(R.id.Topic_TextView_viewCount);

            String account_id=null;
            String name = "No topic";
            String discription = "No ID";
            String v_url = "Video ID missing";
            String status ="Unknow";
            String v_id="Unknown";
            String like_count="Unknown";
            String dislike_count="Unknown";
            String views="unknown";

        //Getting Values from prev activity:
            Bundle extras = getIntent().getExtras();
            if(extras!= null){
                account_id=extras.getString("account_id");
                name=extras.getString("topic_name");
                discription=extras.getString("discrp");
                v_url = extras.getString("v_url");
                status= extras.getString("status");
                v_id=extras.getString("v_id");
                like_count=extras.getString("like_count");
                dislike_count=extras.getString("dislike_count");
                views=extras.getString("views");
            }

            discrip_view.setText(discription);
            tv_like.setText(like_count);
            tv_dislike.setText(dislike_count);
            tv_views.setText(views);

            //YouTube VideoPLayer:
            youTubePlayerView = findViewById(R.id.YoutubePlayerView);
            getLifecycle().addObserver(youTubePlayerView);

        String finalV_url = v_url;
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    youTubePlayer.loadVideo(finalV_url, 0);
                }
            });

        String finalAccount_id = account_id;
        String finalV_id = v_id;
        b_likeVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "Liked", Toast.LENGTH_SHORT).show();

                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                    ApiFunctions.UsingGetAPI("http://3.109.14.4/SpacTube/api_extractlike?uid="+ finalAccount_id +"2&vid=3"+ finalV_id);}});
                    thread.start();

                }
            });
        b_dislikeVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "Disliked", Toast.LENGTH_SHORT).show();

                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                    ApiFunctions.UsingGetAPI("http://3.109.14.4/SpacTube/api_getDisLike?uid="+finalAccount_id+"2&vid="+finalV_id);}});
                    thread.start();
                }
            });
        b_share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(Intent.ACTION_SEND);
                    myIntent.setType("text/plain");
                    myIntent.putExtra(Intent.EXTRA_SUBJECT,"Hey!, check this out"+ finalV_url);
                    myIntent.putExtra(Intent.EXTRA_TEXT,"SpaceTube");
                    startActivity(Intent.createChooser(myIntent,"Share Using"));
                }
            });
        b_comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                EditText commentText = findViewById(R.id.Topic_EditText_Comment);
                String comment= URLEncoder.encode(commentText.getText().toString());
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                           ApiFunctions.UsingGetAPI("http://3.109.14.4/SpacTube/api_extractlike?uid="+ finalAccount_id +"2&vid=3"+ comment);}});
                    thread.start();
                    commentText.clearComposingText();
                }});
    }}
