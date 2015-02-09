package fr.cobalt.codedarmor.fragments;

import fr.cobalt.codedarmor.R;

import fr.cobaltians.cobalt.fragments.CobaltFragment;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class DetailedEventsFragment extends CobaltFragment {

    private static final String TAG = DetailedEventsFragment.class.getSimpleName();

    private static final String LINK_NAME = "link";
    private static final String INTENT_TYPE_PLAIN = "text/plain";

    /***********************************************************************************************
     * COBALT
     **********************************************************************************************/

	@Override
	protected int getLayoutToInflate() {
		return fr.cobaltians.cobalt.R.layout.fragment_refresh_cobalt;
	}

	@Override
	protected boolean onUnhandledEvent(String event, JSONObject data, String callback) {
		String link = null;

        switch(event) {
            case "register":
                try {
                    link = data.getString(LINK_NAME);
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));
                }
                catch (JSONException exception) {
                    Log.w(TAG, "Missing link field in data for event register");
                    exception.printStackTrace();
                }

                break;
            case "share":
                try {
                    link = data.getString(LINK_NAME);
                    String title = data.getString("title");

                    Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                    intent.setType(INTENT_TYPE_PLAIN);
                    intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
                    intent.putExtra(Intent.EXTRA_TEXT, String.format(getString(R.string.intent_share_event_text), title, link));
                    startActivity(Intent.createChooser(intent, getString(R.string.intent_chooser_title)));
                }
                catch (JSONException exception) {
                    Log.w(TAG, "Missing link and or title field(s) in data for event share");
                    exception.printStackTrace();
                }

                break;
            case "sharePhoto":
                try {
                    link = data.getString(LINK_NAME);

                    Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                    intent.setType(INTENT_TYPE_PLAIN);
                    intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
                    intent.putExtra(Intent.EXTRA_TEXT, String.format(getString(R.string.intent_share_photo_text), link));
                    startActivity(Intent.createChooser(intent, getString(R.string.intent_chooser_title)));
                }
                catch (JSONException exception) {
                    Log.w(TAG, "Missing link field in data for event register");
                    exception.printStackTrace();
                }

                break;
            default:
                return false;
        }

        return true;
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
