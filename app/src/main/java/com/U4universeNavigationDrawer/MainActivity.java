package com.U4universeNavigationDrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.U4universeNavigationDrawer.Fragment.FragmentBackup;
import com.U4universeNavigationDrawer.Fragment.FragmentColorLens;
import com.U4universeNavigationDrawer.Fragment.FragmentGrade;
import com.U4universeNavigationDrawer.Fragment.FragmentHDR;
import com.U4universeNavigationDrawer.Fragment.FragmentPAN;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mdrawerLayout;
    Toolbar mtoolbar;
    NavigationView mnavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer_layout);
        initViews();
        usetoolbar();
        addHumberDesingnAndSync();
        navigationViewOnclickItem();

        opendefautlFragment(savedInstanceState);
    }
    private void initViews() {
        mtoolbar = (Toolbar) findViewById(R.id.toolbar_mainActivity);
        mdrawerLayout = findViewById(R.id.drawerlayout);
        mnavigationView = (NavigationView) findViewById(R.id.navView);
    }
    private void usetoolbar() {
        setSupportActionBar(mtoolbar);
    }
    private void addHumberDesingnAndSync() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                mdrawerLayout,
                mtoolbar,
                R.string.nav_open,
                R.string.nav_close);  // Here close and open String used for Blind people using Navigation Drawer.
        mdrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }
    private void navigationViewOnclickItem(){
        /*Approach 1
        mnavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return false;
            }
        });*/
        /* Approach 2*/
        mnavigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed() {
        if (mdrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mdrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     *Here in this method we need to return true if we want the selceted item to be show in some selelected animation in the background.
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.backkup:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_Container,new FragmentBackup()).commit();
                break;
            case R.id.lens:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_Container,new FragmentColorLens()).commit();
                break;
            case R.id.grade:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_Container,new FragmentGrade()).commit();
                break;
            case R.id.hdr:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_Container,new FragmentHDR()).commit();
                break;
            case R.id.pantool:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_Container,new FragmentPAN()).commit();
                break;
        }
        mdrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void opendefautlFragment(Bundle savedInstance){
        if(savedInstance==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_Container,new FragmentBackup()).commit();
        }
        highlightSelectedItem(R.id.backkup);
    }

    private void highlightSelectedItem(int idSelectedItem){
        mnavigationView.setCheckedItem(idSelectedItem);
    }
}

