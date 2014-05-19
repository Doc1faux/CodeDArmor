package fr.cobalt.codedarmor.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import fr.cobalt.codedarmor.R;
import fr.cobalt.codedarmor.fragments.ListFragment;
import fr.cobaltians.cobalt.Cobalt;
import fr.cobaltians.cobalt.activities.CobaltActivity;
import fr.cobaltians.cobalt.fragments.CobaltFragment;

public class ListActivity extends CobaltActivity {

	@Override
	protected int getLayoutToInflate() {
		return R.layout.activity_home;
	}

	@Override
	protected CobaltFragment getFragment() {

		return Cobalt.getInstance(this).getFragmentForController(ListFragment.class, "ListView", "eventsList.html");
	}

	public void changeFragment(Fragment frag) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();

		fragmentTransaction.replace(R.id.fragment_container, frag);
		fragmentTransaction.commit();

		DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerLayout.closeDrawers();
	}

}
