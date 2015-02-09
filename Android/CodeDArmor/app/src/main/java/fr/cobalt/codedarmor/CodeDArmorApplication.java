package fr.cobalt.codedarmor;

import fr.cobaltians.cobalt.Cobalt;

import android.app.Application;

public class CodeDArmorApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		Cobalt.DEBUG = true;
	}
}
