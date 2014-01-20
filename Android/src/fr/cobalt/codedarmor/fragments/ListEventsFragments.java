package fr.cobalt.codedarmor.fragments;

import fr.cobalt.codedarmor.R;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import fr.haploid.androidnativebridge.fragments.HTMLPullToRefreshFragment;

public class ListEventsFragments extends HTMLPullToRefreshFragment{
	
	    private DrawerLayout mDrawerLayout;
	    

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = super.onCreateView(inflater, container, savedInstanceState);
		//Getting the first web page from assets
		this.ressourcePath = "www/";
		
		if(!webviewContentHasBeenLoaded)
		{
			//loadFileContentFromAssets(this.ressourcePath, (this.pageName != null) ? this.pageName : "eventsList.html");
			pageName = "eventsList.html";
		}
        mDrawerLayout = (DrawerLayout) this.getActivity().findViewById(R.id.drawer_layout);


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
