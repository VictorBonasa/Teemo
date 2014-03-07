package com.victor.teemo;


import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.victor.teemo.util.Constantes;

public class DesktopTeemo {

	public static void main(String[] args) {
		LwjglApplicationConfiguration configuracion = new LwjglApplicationConfiguration();
		configuracion.title = "Teemo";
		configuracion.width = Constantes.SCREEN_ANCHO;
		configuracion.height = Constantes.SCREEN_ALTO;
		
		configuracion.fullscreen = false;
				
		new LwjglApplication(new Teemo(), configuracion);
	}
}

