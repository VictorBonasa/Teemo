package com.victor.teemo.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.victor.teemo.managers.ConfigurationManger;
import com.victor.teemo.managers.ResourceManager;
import com.victor.teemo.managers.SpriteManager;
import com.victor.teemo.util.Constantes;

public class TeemoPersonaje extends Character{
	
	private int puntuacion;
	private ConfigurationManger configurationManager;

	public TeemoPersonaje(float x, float y, float velocidad, ConfigurationManger configurationManager) {
		super(x, y, velocidad);
		
		puntuacion = 0;
		animacion = ResourceManager.getAnimation("teemo");
		//TODO si fuera necesario cambiar la altura y la anchura ya que lleva las mismas que los enemigos
		setRectangulo(new Rectangle(x,y,Constantes.ANCHURA_ENEMIGO,Constantes.ALTURA_ENEMIGO));
		this.configurationManager = configurationManager;
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(frameActual, getX(), getY());
		
	}
	
	public void update(float dt, SpriteManager spriteManager){
		stateTime += Gdx.graphics.getDeltaTime();
		frameActual = animacion.getKeyFrame(stateTime, true);
		
		
		if (Gdx.input.isKeyPressed(Keys.A)) {
			
			if (getX() > 0)
				setX(getX() - getVelocidad() * dt);
		}
		
		if (Gdx.input.isKeyPressed(Keys.D)) {
			
			if (getX() < Constantes.SCREEN_ANCHO - Constantes.ANCHURA_ENEMIGO - 10f)
				setX(getX() +getVelocidad() * dt);
		}
		
		if (Gdx.input.isKeyPressed(Keys.S)) {
			
			if (getY() > 5f)
				setY(getY() - getVelocidad() * dt);
		}
		
		if (Gdx.input.isKeyPressed(Keys.W)) {
			
			if (getY() < Constantes.SCREEN_ALTO - Constantes.ALTURA_ENEMIGO)
				setY(getY() + getVelocidad() * dt);
		}
		
		setRectanguloX(getX());
		setRectanguloY(getY());
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public ConfigurationManger getConfigurationManager() {
		return configurationManager;
	}

	public void setConfigurationManager(ConfigurationManger configurationManager) {
		this.configurationManager = configurationManager;
	}
	
	

}
