package com.bookbank.bookbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.bookbank.bookbank.Available_Books.AvailabeBookFragment;
import com.bookbank.bookbank.Request_Book.MoreFragment;
import com.bookbank.bookbank.Request_Book.OnlineLibraryFragment;
import com.bookbank.bookbank.Request_Book.RequestBookFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class bottom_navigation extends AppCompatActivity {

    BottomNavigationView bottom_navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        bottom_navigation = findViewById(R.id.bottom_navigation);
        bottom_navigation.setOnNavigationItemSelectedListener(navListner);
        getSupportFragmentManager().beginTransaction().replace(R.id.fr, new AvailabeBookFragment()).commit();

    }
    private final BottomNavigationView.OnNavigationItemSelectedListener navListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment =null;
                    switch (item.getItemId()){
                        case R.id.navigation_availableBooks:
                            selectedFragment=new AvailabeBookFragment();
                            break;

                        case R.id.navigation_onlineBook:
                            selectedFragment=new OnlineLibraryFragment();
                            break;

                        case R.id.navigation_requestBook:
                            selectedFragment=new RequestBookFragment();
                            break;

                        case R.id.navigation_more:
                            selectedFragment=new MoreFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fr,selectedFragment).commit();
                    return true;
                }
            };
}