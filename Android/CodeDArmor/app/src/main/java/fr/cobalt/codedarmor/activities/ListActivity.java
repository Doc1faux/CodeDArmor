package fr.cobalt.codedarmor.activities;

import fr.cobalt.codedarmor.R;
import fr.cobalt.codedarmor.fragments.ListFragment;

import fr.cobaltians.cobalt.Cobalt;
import fr.cobaltians.cobalt.activities.CobaltActivity;
import fr.cobaltians.cobalt.fragments.CobaltFragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;

public class ListActivity extends CobaltActivity {

    private ActionBarDrawerToggle mDrawerToggle;

    /***********************************************************************************************
     * LIFECYCLE
     **********************************************************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(  this, drawerLayout,
                                                    R.string.navigation_drawer_open,
                                                    R.string.navigation_drawer_close) { };

        // Set the drawer toggle as the DrawerListener
        drawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    /***********************************************************************************************
     * MENU
     **********************************************************************************************/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle,
        // if it returns true,
        // then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) return true;
        
        return super.onOptionsItemSelected(item);
    }

    /***********************************************************************************************
     * COBALT
     **********************************************************************************************/

	@Override
	protected int getLayoutToInflate() {
		return R.layout.activity_list;
	}

	@Override
	protected CobaltFragment getFragment() {
		return Cobalt.getInstance(this).getFragmentForController(ListFragment.class, "ListView", "eventsList.html");
	}

    /***********************************************************************************************
     * HELPERS
     **********************************************************************************************/

	public void switchFragment(final Fragment fragment) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();

                DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawers();
            }
        });
	}
}
