package com.victor.teemo.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.victor.teemo.util.Constantes;

public class ConfigurationManger {
	
	private Preferences prefs;
	
	public ConfigurationManger(){
		prefs = Gdx.app.getPreferences(Constantes.APP);
	}

}
