package fr.cobalt.codedarmor.fragments;

import org.json.JSONObject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import fr.cobaltians.cobalt.fragments.HTMLFragment;

public class SideMenuFragment extends HTMLFragment{

	/**
	 * @param args
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		
		mPage="sideMenu.html";
		enableLogging(true);

		
 View view = super.onCreateView(inflater, container, savedInstanceState);
		//Getting the first web page from assets
		
 		

		return view;
	}

	@Override
	public void onStart() {
		super.onStart();
		
	}

	@Override
	protected boolean onUnhandledCallback(String callback, JSONObject data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean onUnhandledEvent(String event, JSONObject data,
			String callback) {
		System.out.println(data.toString());
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void onUnhandledMessage(JSONObject message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onPullToRefreshRefreshed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onInfiniteScrollRefreshed() {
		// TODO Auto-generated method stub
		
	}

}
