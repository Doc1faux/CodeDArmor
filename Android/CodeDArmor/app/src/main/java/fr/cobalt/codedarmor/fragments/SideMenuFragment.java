package fr.cobalt.codedarmor.fragments;

import fr.cobalt.codedarmor.activities.ListActivity;

import fr.cobaltians.cobalt.Cobalt;
import fr.cobaltians.cobalt.fragments.CobaltFragment;

import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

public class SideMenuFragment extends CobaltFragment {

    private static final String TAG = SideMenuFragment.class.getSimpleName();

	private HashMap<String, CobaltFragment> mFragmentStack;

    /***********************************************************************************************
     * LIFECYCLE
     **********************************************************************************************/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFragmentStack = new HashMap<String, CobaltFragment>();
    }

    /***********************************************************************************************
     * COBALT
     **********************************************************************************************/

	@Override
	protected String getPage() {
		return "sideMenu.html";
	}

	@Override
	protected boolean onUnhandledEvent(String event, JSONObject data, String callback) {
		if (event.equals("switchFragment")) {
			try {
				String page = data.getString("page");

                CobaltFragment fragment = null;
                if (mFragmentStack.containsKey(page)) fragment = mFragmentStack.get(page);
                else {
                    fragment = Cobalt.getInstance(mContext).getFragmentForController(ListFragment.class, "ListView", page + ".html");
                    mFragmentStack.put(page, fragment);
                }

                ((ListActivity) mContext).switchFragment(fragment);
			}
            catch (JSONException exception) {
				Log.d(TAG, "Missing page field in data");
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
