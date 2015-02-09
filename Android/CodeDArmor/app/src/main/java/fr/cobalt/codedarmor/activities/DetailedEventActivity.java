package fr.cobalt.codedarmor.activities;

import fr.cobalt.codedarmor.fragments.DetailedEventsFragment;

import fr.cobaltians.cobalt.activities.CobaltActivity;
import fr.cobaltians.cobalt.fragments.CobaltFragment;

public class DetailedEventActivity extends CobaltActivity {

	protected CobaltFragment getFragment() {
		return new DetailedEventsFragment();
	}
}
