package fr.cobalt.codedarmor.fragments;

import fr.cobaltians.cobalt.fragments.CobaltFragment;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class ListFragment extends CobaltFragment {

    private static final String TAG = ListFragment.class.getSimpleName();

    /***********************************************************************************************
     * COBALT
     **********************************************************************************************/

    @Override
    protected boolean onUnhandledEvent(String event, JSONObject data, String callback) {
        if (event.equals("PlayVideo")) {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(data.getString("link"))));
            }
            catch (JSONException exception) {
                Log.w(TAG, "Missing link field in data");
                exception.printStackTrace();
            }

            return true;
        }

        return false;
    }

	@Override
	protected boolean onUnhandledCallback(String callback, JSONObject data) {
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
