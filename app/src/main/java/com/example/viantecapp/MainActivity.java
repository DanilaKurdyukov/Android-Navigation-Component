package com.example.viantecapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        navController = navHostFragment.getNavController();
        NavigationView sideBar = findViewById(R.id.nav_menu);
        NavigationUI.setupWithNavController(sideBar,navController);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph())
                .setDrawerLayout(findViewById(R.id.drawer_layout))
                .build();
        Toolbar mainAppBar = findViewById(R.id.main_app_bar);
        setSupportActionBar(mainAppBar);
        getSupportActionBar().setTitle("Уведомления");
        NavigationUI.setupWithNavController(mainAppBar,navController,appBarConfiguration);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
                if (navDestination.getLabel().equals("Уведомления")){
                    mainAppBar.setNavigationIcon(R.drawable.ic_baseline_dehaze_24);
                }
                else{
                    mainAppBar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
                }
            }
        });
        moveToSettingFragment(navController,sideBar);
    }
    private void moveToSettingFragment(NavController navController,NavigationView sideBar){
        View navigationHeader = sideBar.getHeaderView(0);
        AppCompatButton btnSettings = navigationHeader.findViewById(R.id.button_settings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.settingsFragment);
                DrawerLayout layout = findViewById(R.id.drawer_layout);
                layout.closeDrawers();
            }
        });
    }
}