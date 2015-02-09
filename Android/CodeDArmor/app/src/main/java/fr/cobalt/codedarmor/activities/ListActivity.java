package fr.cobalt.codedarmor.activities;

import fr.cobalt.codedarmor.R;
import fr.cobalt.codedarmor.fragments.ListFragment;

import fr.cobaltians.cobalt.Cobalt;
import fr.cobaltians.cobalt.activities.CobaltActivity;
import fr.cobaltians.cobalt.fragments.CobaltFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;

public class ListActivity extends CobaltActivity {

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
