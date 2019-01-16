package com.example.gmax1.recordo_playstore;

import android.content.Intent;
import android.widget.Toast;

import com.example.gmax1.recordo_playstore.fragment.BaseActivity;
import com.example.gmax1.recordo_playstore.fragment.PresetsFragment;
import com.example.gmax1.recordo_playstore.models.Sonometre;

import butterknife.OnClick;


public class MainActivity extends BaseActivity /*implements NavigationView.OnNavigationItemSelectedListener*/ {
    /*private TextView mTextNbreDecibels;
    static final private double EMA_FILTER = 0.6;
    private MediaRecorder mRecorder = null;
    private double mEMA = 0.0;*/


    @Override
    public int getLayoutContentViewID() { return R.layout.fragment_sonometre; }
/*
    //For Design
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 6 - Configure all views
        //this.configureDrawerLayout();
        //this.configureNavigationView();
        //this.configureToolBar();

        if (savedInstanceState == null) {
            sonometre();
            // navigationView.setCheckedItem(R.id.activity_main_toolbar);
        }
        start();
        mTextNbreDecibels = (TextView) findViewById(R.id.textViewNbreDecibels);
        mTextNbreDecibels.setText(Double.toString(dB));
    }

    @Override
    public void onBackPressed() {
        // 5 - Handle back click to close menu
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        // 4 - Handle Navigation Item Click
        int id = item.getItemId();

        switch (id) {
            case R.id.navigation_presets:
                presets();
                break;
            case R.id.navigation_recording:
                recording();
                break;
            case R.id.navigation_settings:
                settings();
                break;
            case R.id.navigation_sono:
                sonometre();
                break;
            default:
                break;
        }

        this.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }*/

    // ---------------------
    // CONFIGURATION
    // ---------------------

    // 1 - Configure Toolbar
   /*private void configureToolBar() {
        this.toolbar = findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(toolbar);

    }*/
/*
    // 2 - Configure Drawer Layout
    private void configureDrawerLayout() {
        this.drawerLayout = findViewById(R.id.activity_main_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    // 3 - Configure NavigationView
    private void configureNavigationView() {
        this.navigationView = findViewById(R.id.activity_main_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
*/
/*
    private void recording() {
        Toast.makeText(this, "Recording", Toast.LENGTH_SHORT).show();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main_frame_layout, new RecordingFragment())
                .commit();
    }

    private void settings() {
        Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main_frame_layout, new SettingsFragment())
                .commit();
    }
*/
    @OnClick(R.id.sonometre_goto_preset)
    public void presets() {
        Toast.makeText(this, "Presets", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, PresetsFragment.class);
        startActivity(intent);
        /*getSupportFragmentManager();
                .beginTransaction()
                .replace(R.id.activity_main_frame_layout, new PresetsFragment())
                .commit();*/
    }

    private void sonometre() {
        Toast.makeText(this, "Sonometre", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Sonometre.class);
        startActivity(intent);
        /*getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main_frame_layout, new SonometreFragment())
                .commit();*/
    }
}
