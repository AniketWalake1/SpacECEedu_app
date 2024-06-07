package com.spacECE.spaceceedu.LibForSmall;

<<<<<<< HEAD
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
=======
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
>>>>>>> origin/khushi

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
<<<<<<< HEAD

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.spacECE.spaceceedu.HomeFragmentLibForSmall;
import com.spacECE.spaceceedu.R;
=======
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.spacECE.spaceceedu.MainActivity;
import com.spacECE.spaceceedu.R;
import com.spacECE.spaceceedu.Utils.UsefulFunctions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
>>>>>>> origin/khushi

import java.util.ArrayList;

public class Library_main extends AppCompatActivity {

    public static ArrayList<books> list = new ArrayList<>();
<<<<<<< HEAD
    private Fragment currentFragment = null;
=======

>>>>>>> origin/khushi
    Fragment fragment=new library_list();
    public  FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_main);
<<<<<<< HEAD
        getSupportFragmentManager().beginTransaction().replace(R.id.libs_for_small_fragment_container, fragment).commit();

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

=======
        getSupportFragmentManager().beginTransaction().replace(R.id.book_framelayout, fragment).commit();

        floatingActionButton=findViewById(R.id.floatingActionBtnBottom);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Library_main.this, AddBook.class);
                startActivity(i);
            }
        });
>>>>>>> origin/khushi

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomAppBar);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
<<<<<<< HEAD
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menuHome:
                        replaceFragment(new HomeFragmentLibForSmall());
                        return true;

                    case R.id.menuBook:
                        Toast.makeText(Library_main.this, "Welcome to Profile", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.menuChat:
                        Toast.makeText(Library_main.this, "Welcome to Help Section", Toast.LENGTH_SHORT).show();
                        return true;


                    default:
                        return false;
                }
            }
        });
        replaceFragment(new HomeFragmentLibForSmall());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if(id==R.id.toolbar_menu_home){
            replaceFragment(new HomeFragmentLibForSmall());
        }
        if(id==R.id.toolbar_menu_add_books){
            replaceFragment(new AddBooks());
        }
        if(id==R.id.toolbar_menu_exchange_requests){
            Toast.makeText(this, "Place your Exchange Request Here", Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.toolbar_menu_my_books){
            replaceFragment(new MyBooks());
        }
        return true;
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.libs_for_small_fragment_container, fragment).commit();
        currentFragment = fragment;
    }

=======
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuBook:
                        startActivity(new Intent(getApplicationContext(),library_my_books.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menuChat:
                        startActivity(new Intent(getApplicationContext(), ChatUS.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menuHome:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return  false;
            }
        });




    }
>>>>>>> origin/khushi
}



