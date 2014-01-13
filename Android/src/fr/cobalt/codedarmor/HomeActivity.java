package fr.cobalt.codedarmor;


import fr.haploid.androidnativebridge.activities.HTMLActivity;
import fr.haploid.androidnativebridge.fragments.HTMLFragment;
import fragments.HomeFragment;


public class HomeActivity extends HTMLActivity {



	
	protected HTMLFragment getFragment(){
		
		return new HomeFragment();
		
		
		
	}

}
