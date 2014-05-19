package fr.cobalt.codedarmor.fragments;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import fr.cobalt.codedarmor.R;
import fr.cobaltians.cobalt.fragments.CobaltFragment;

public class DetailedEventsFragment extends CobaltFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = super.onCreateView(inflater, container, savedInstanceState);
		// Getting the first web page from assets

		return view;
	}

	@Override
	protected int getLayoutToInflate() {
		return R.layout.detailedview_layout;
	}

	@Override
	protected boolean onUnhandledCallback(String callback, JSONObject data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean onUnhandledEvent(String event, JSONObject data,
			String callback) {
		System.out.println("trigger envent");
		if (event.equals("register")) {

			String link = "Undefined";
			try {
				link = data.getString("link");
				this.getActivity().startActivity(
						new Intent(Intent.ACTION_VIEW, Uri.parse(link)));

			} catch (JSONException e) {
				System.out.println(e + "  Value is :" + link);
				e.printStackTrace();
			}

		} else if (event.equals("share")) {

			String link = "Undefined";
			String title = "Undefined";
			try {
				link = data.getString("link");
				title = data.getString("title");
				Intent s = new Intent(android.content.Intent.ACTION_SEND);

				s.setType("text/plain");
				s.putExtra(Intent.EXTRA_SUBJECT, "Code d'Armor");
				s.putExtra(Intent.EXTRA_TEXT, "Inscrivez vous à l'évènement \""
						+ title + "\" : " + link);

				startActivity(Intent.createChooser(s,
						"Choisissez l'application"));

			} catch (JSONException e) {
				e.printStackTrace();
			}

		} else if (event.equals("sharePhoto")) {

			String link = "Undefined";
			try {
				link = data.getString("link");
				Intent s = new Intent(android.content.Intent.ACTION_SEND);

				s.setType("text/plain");
				s.putExtra(Intent.EXTRA_SUBJECT, "Code d'Armor");
				s.putExtra(Intent.EXTRA_TEXT,
						"Photo des soirées Code d'Armor : " + link);

				startActivity(Intent.createChooser(s,
						"Choisissez l'application"));

			} catch (JSONException e) {
				System.out.println(e + "  Value is :" + link);
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
