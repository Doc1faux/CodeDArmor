package fr.cobalt.codedarmor.fragments;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import fr.cobalt.codedarmor.R;
import fr.haploid.androidnativebridge.fragments.HTMLPullToRefreshFragment;

public class DetailedEventsFragment extends HTMLPullToRefreshFragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		
		this.ressourcePath = "www/";
		
		if(!webviewContentHasBeenLoaded)
		{
			pageName = "detailedEvents.html";
		}
		
		View view = super.onCreateView(inflater, container, savedInstanceState);
		//Getting the first web page from assets
		


		return view;
	}
	
	@Override
	protected int getLayoutToInflate()
	{
		return R.layout.activity_home;
	}
	
	@Override
	public void onStart() {
		super.onStart();
		//Enabling pull to refresh on start
		if (getArguments() == null) {
			enablePullToRefresh();
		}
	}

}
