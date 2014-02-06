


package com.victor.teemo;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopTeemo {

	public static void main(String[] args) {
		LwjglApplicationConfiguration configuracion = new LwjglApplicationConfiguration();
		configuracion.title = "Teemo Mushrooms! ^.^";
		configuracion.width = 1024;
		configuracion.height = 786;
		
		new LwjglApplication(new Teemo(), configuracion);

	}

}
