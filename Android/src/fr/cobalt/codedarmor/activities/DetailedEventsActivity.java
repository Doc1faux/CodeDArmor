package fr.cobalt.codedarmor.activities;

import fr.cobalt.codedarmor.fragments.DetailedEventsFragment;
import fr.cobalt.codedarmor.fragments.ListEventsFragments;
import fr.haploid.androidnativebridge.activities.HTMLActivity;
import fr.haploid.androidnativebridge.fragments.HTMLFragment;

public class DetailedEventsActivity extends HTMLActivity {

	protected HTMLFragment getFragment() {

		return new DetailedEventsFragment();

	}
}
