package fr.cobalt.codedarmor.activities;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import fr.cobalt.codedarmor.R;
import fr.cobalt.codedarmor.fragments.ListFragment;
import fr.cobaltians.cobalt.activities.HTMLActivity;
import fr.cobaltians.cobalt.fragments.HTMLFragment;

public class ListActivity extends HTMLActivity {
	
	@Override
	protected int getLayoutToInflate() {
		return R.layout.activity_home;
	}

	@Override
	protected HTMLFragment getFragment(){
		
		return new ListFragment();	
	}

	public void changeFragment(Fragment frag){
		
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.replace(R.id.fragment_container, frag);
		fragmentTransaction.commit();

		 DrawerLayout mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
		 mDrawerLayout.closeDrawers();
	}
}
