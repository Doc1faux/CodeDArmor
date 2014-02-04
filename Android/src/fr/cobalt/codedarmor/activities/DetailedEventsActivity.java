package fr.cobalt.codedarmor.activities;

import fr.cobalt.codedarmor.fragments.DetailedEventsFragment;
import fr.cobaltians.cobalt.activities.HTMLActivity;
import fr.cobaltians.cobalt.fragments.HTMLFragment;


public class DetailedEventsActivity extends HTMLActivity {

	protected HTMLFragment getFragment() {

		return new DetailedEventsFragment();

	}
}
