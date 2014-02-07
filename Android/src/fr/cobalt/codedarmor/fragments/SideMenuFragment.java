package fr.cobalt.codedarmor.fragments;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import fr.cobalt.codedarmor.R;
import fr.cobalt.codedarmor.activities.ListActivity;
import fr.cobaltians.cobalt.fragments.HTMLFragment;

public class SideMenuFragment extends HTMLFragment{

	/**
	 * @param args
	 */
	private HashMap<String, HTMLFragment> fragmentPile;
	private HTMLFragment currentFragment;
	private ListActivity act;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
			act= (ListActivity)getActivity();

		currentFragment=new HTMLFragment() {
			
			@Override
			protected void onUnhandledMessage(JSONObject message) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			protected boolean onUnhandledEvent(String event, JSONObject data,
					String callback) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			protected boolean onUnhandledCallback(String callback, JSONObject data) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			protected void onPullToRefreshRefreshed() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			protected void onInfiniteScrollRefreshed() {
				// TODO Auto-generated method stub
				
			}
		};
		fragmentPile=new HashMap<String, HTMLFragment>();
		
		mPage="sideMenu.html";
		enableLogging(true);

		
 View view = super.onCreateView(inflater, container, savedInstanceState);
		//Getting the first web page from assets
		
 		

		return view;
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
		
			if (event.equals("switchFragment")){
				
				
				act= (ListActivity)getActivity();

				
				HTMLFragment fragmentToCommit=null;
				HTMLFragment fragmentPointer;
				
				
				
			System.out.println("Web asked to switch fragment");
			// Lookin for the good fragment in the pile
			// Add it if necessary
			try {
				String page=data.getString("page");

				if(page.equals("eventsList")){
					
					fragmentPointer=fragmentPile.get("eventsList");
					if(fragmentPointer!=null){
						
						fragmentToCommit=fragmentPointer;


						
					}
					else{
						
						fragmentPile.put("eventsList",getFragmentForController(getActivity(), ListFragment.class, "ListView", page+".html"));
						fragmentToCommit=fragmentPile.get("eventsList");



						
					}
					
				}
				else if(page.equals("photosList")){
					
					fragmentPointer=fragmentPile.get("photosList");
					
					if(fragmentPointer!=null){
						
						fragmentToCommit=fragmentPointer;


					}
					else{
						
						fragmentPile.put("photosList",getFragmentForController(getActivity(), ListFragment.class, "ListView", page+".html"));
						fragmentToCommit=fragmentPile.get("photosList");
						
					}
					
					
				}
				else if(page.equals("videoslist")){
					
					fragmentPointer=fragmentPile.get("videosList");
					
					if(fragmentPointer!=null){
						
						fragmentToCommit=fragmentPointer;
					}
					else{
						
						fragmentPile.put("videosList",getFragmentForController(getActivity(), ListFragment.class, "ListView", page+".html"));
						fragmentToCommit=fragmentPile.get("videosList");


						
					}
					
					
					
				}
				else if(page.equals("slideList")){
					
					fragmentPointer=fragmentPile.get("slideList");
					
					if(fragmentPointer!=null){
						
						fragmentToCommit=fragmentPointer;
					}
					else{
						
						fragmentPile.put("slideList",getFragmentForController(getActivity(), ListFragment.class, "ListView", page+".html"));
						fragmentToCommit=fragmentPile.get("slideList");

					}
						
					
					
					
				}
				
				

				

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				System.out.println("Master error");
				e.printStackTrace();
			}
			System.out.println("Going to commit...");

			
			act.changeFragment(fragmentToCommit);

			
			
			
			
			
			
		}
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
