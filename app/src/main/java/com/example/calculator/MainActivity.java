package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.calculator.fragment.ProgrammerFragment;
import com.example.calculator.fragment.ScientificFragment;
import com.example.calculator.fragment.StandardFragment;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int FRAGMENT_STANDARD = 0;
    private static final int FRAGMENT_SCIENTIFIC = 1;
    private static final int FRAGMENT_PROGRAMMER = 2;
    private int mCurrentFragment = FRAGMENT_STANDARD;
    public DrawerLayout mDrawerLayout;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        replaceFragment(new StandardFragment());
        navigationView.getMenu().findItem(R.id.nav_standard).setChecked(true);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        toolbar = findViewById(R.id.toolbar);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        if( id == R.id.nav_standard){
            if(mCurrentFragment != FRAGMENT_STANDARD ){
                replaceFragment(new StandardFragment());
                mCurrentFragment = FRAGMENT_STANDARD;
                navigationView.getMenu().findItem(R.id.nav_standard).setChecked(true);
                navigationView.getMenu().findItem(R.id.nav_Scientific).setChecked(false);
                navigationView.getMenu().findItem(R.id.nav_programmer).setChecked(false);

                toolbar.setTitle("Standard");
            }
        } else if(id == R.id.nav_Scientific){
            if(mCurrentFragment != FRAGMENT_SCIENTIFIC ){
                replaceFragment(new ScientificFragment());
                mCurrentFragment = FRAGMENT_SCIENTIFIC;
                navigationView.getMenu().findItem(R.id.nav_standard).setChecked(false);
                navigationView.getMenu().findItem(R.id.nav_Scientific).setChecked(true);
                navigationView.getMenu().findItem(R.id.nav_programmer).setChecked(false);

                toolbar.setTitle("Scientific");
            }
        } else if(id == R.id.nav_programmer){
            if(mCurrentFragment != FRAGMENT_PROGRAMMER ){
                replaceFragment(new ProgrammerFragment());
                mCurrentFragment = FRAGMENT_PROGRAMMER;
                navigationView.getMenu().findItem(R.id.nav_standard).setChecked(false);
                navigationView.getMenu().findItem(R.id.nav_Scientific).setChecked(false);
                navigationView.getMenu().findItem(R.id.nav_programmer).setChecked(true);

                toolbar.setTitle("Programmer");
            }
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else{
            super.onBackPressed();
        }
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame,fragment);
        transaction.commit();
    }
}