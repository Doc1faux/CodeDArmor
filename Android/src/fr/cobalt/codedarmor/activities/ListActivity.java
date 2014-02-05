package fr.cobalt.codedarmor.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
	}
}
