package com.apiprojects.musicapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.apiprojects.musicapp.Fragments.CreditsFragment;
import com.apiprojects.musicapp.Fragments.HomeFragment;
import com.apiprojects.musicapp.Fragments.SearchFragment;
import com.apiprojects.musicapp.Fragments.TracksFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation();
    }

    private void bottomNavigation() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.home:
                                selectedFragment = HomeFragment.homeFragment();
                                break;
                            case R.id.songs:
                                selectedFragment = SearchFragment.searchFragment();
                                break;
                            case R.id.credits:
                                selectedFragment = CreditsFragment.creditsFragment();
                                break;
                            case R.id.tracks:
                                selectedFragment = TracksFragment.tracksFragment();
                                break;

                            case R.id.logout:
                                finish();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, HomeFragment.homeFragment());
        transaction.commit();
    }

}