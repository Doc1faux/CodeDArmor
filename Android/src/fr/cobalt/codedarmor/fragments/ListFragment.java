package fr.cobalt.codedarmor.fragments;

import org.json.JSONException;
import org.json.JSONObject;

import fr.cobalt.codedarmor.R;
import fr.cobaltians.cobalt.fragments.HTMLFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.widget.ListView;



public class ListFragment extends HTMLFragment{
	
	    private DrawerLayout mDrawerLayout;
	    

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		this.mDrawerLayout = (DrawerLayout) this.getActivity().findViewById(R.id.drawer_layout);

		View view = super.onCreateView(inflater, container, savedInstanceState);
		//Getting the first web page from assets
		this.mPage="eventsList.html";
		enableLogging(true);


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
	
	@Override
	@JavascriptInterface
	public boolean handleMessageSentByJavaScript(String messageJS) {

		
		
		return super.handleMessageSentByJavaScript(messageJS);	
	}

	@Override
	protected boolean onUnhandledCallback(String callback, JSONObject data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean onUnhandledEvent(String event, JSONObject data,
			String callback) {

		
			// Catch a "Play video event" and trigger an intent
			if(event.equals("PlayVideo")){
				
				String link="Undefined";
				try {
					link = data.getString("link");
					this.getActivity().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));

				} catch (JSONException e) {
					System.out.println(e+"  Value is :"+link);
					e.printStackTrace();
				}
				

				
			}
		return true;
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
