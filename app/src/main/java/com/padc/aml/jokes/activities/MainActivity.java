package com.padc.aml.jokes.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.padc.aml.jokes.R;
import com.padc.aml.jokes.fragments.ViewFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ViewFragment.ControllerView {
    @Override
    public void onFragmentChange() {

    }

    private int mPageNo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button btnPrevious = (Button) findViewById(R.id.btn_Previous);
        Button btnNext = (Button) findViewById(R.id.btn_Next);

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showJokeContent(mPageNo--);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showJokeContent(mPageNo++);
            }
        });

        if (savedInstanceState == null) {
            showJokeContent(mPageNo++);
        }
    }

    private void showJokeContent(int pageNo){
        if(pageNo > 3) {
            mPageNo = 0;
        }
        else if(pageNo < 1 ){
            mPageNo = 2;
        }

        String title = "";
        String content = "";
        int imageId = 0;
        switch (pageNo) {
            case 2:
                title = getString(R.string.joke_two_title);
                imageId = R.drawable.joke_2;
                content = getString(R.string.joke_two_content);
                break;
            case 3:
                title = getString(R.string.joke_three_title);
                imageId = R.drawable.joke_3;
                content = getString(R.string.joke_three_content);
                break;
            case 1:
            default:
                title = getString(R.string.joke_one_title);
                imageId = R.drawable.joke_1;
                content = getString(R.string.joke_one_content);
                break;
        }
        ViewFragment fragment = ViewFragment.newInstance(title, imageId, content);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container, fragment)
                .commit();
        ;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
