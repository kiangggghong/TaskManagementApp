package com.example.perfectplanner;


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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Random;


public class ActionBar extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    protected DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_side_bar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        fab.hide();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();



        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        //open first <HOME> fragment on default
        if (savedInstanceState == null) {
//            navigationView.getMenu().performIdentifierAction(R.id.nav_Home, 0);
//            navigationView.getMenu().getItem(0).setChecked(true);
        }
        //open drawer on default
        //drawer.openDrawer(GravityCompat.START);

        navigationView.getMenu().performIdentifierAction(R.id.nav_Tasks, 0);
        navigationView.getMenu().getItem(0).setChecked(true);

        View headerview = navigationView.getHeaderView(0);
        ImageView header = (ImageView) headerview.findViewById(R.id.imageView);
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActionBar.this, "clicked", Toast.LENGTH_SHORT).show();
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);

                android.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_side_bar, new Profile()).commit();

            }
        });
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
        getMenuInflater().inflate(R.menu.side_bar, menu);
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
        Toast.makeText(ActionBar.this, item.getItemId(), Toast.LENGTH_LONG).show();
        android.app.FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_Home) {
            fragmentManager.beginTransaction().replace(R.id.content_side_bar, new HomeFragment()).commit();
        } else if (id == R.id.nav_Tasks) {
            fragmentManager.beginTransaction().replace(R.id.content_side_bar, new TaskFragment()).commit();
        } else if (id == R.id.nav_Calendar) {
            fragmentManager.beginTransaction().replace(R.id.content_side_bar, new CalendarFragment()).commit();
        } else if (id == R.id.nav_Friends) {
            fragmentManager.beginTransaction().replace(R.id.content_side_bar, new MainFriendActivity()).commit();
        } else if (id == R.id.nav_Badges) {
            fragmentManager.beginTransaction().replace(R.id.content_side_bar, new MainBadges()).commit();
        } else if (id == R.id.nav_Summary) {
            fragmentManager.beginTransaction().replace(R.id.content_side_bar, new SummaryFragment()).commit();
        } else if (id == R.id.nav_Logout) {
            FirebaseAuth.getInstance().signOut();
        } else {
            fragmentManager.beginTransaction().replace(R.id.content_side_bar, new TaskFragment()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
