package com.victor.teemo.characters;

import com.badlogic.gdx.math.Rectangle;
import com.victor.teemo.managers.ResourceManager;
import com.victor.teemo.util.Constantes;

public class Seta extends Enemy{

	public Seta(float x, float y, float velocidad) {
		super(x, y, velocidad);

		animacion = ResourceManager.getAnimation("seta");
		setRectangulo(new Rectangle(x,y, Constantes.ANCHURA_ENEMIGO, Constantes.ALTURA_ENEMIGO));
		setPuntosValor(50);
		setVidas(1);
	}
	
	@Override
	public void update(float dt) {
		
		super.update(dt);
		/*
		float time =0;
		time +=dt;
		float a=0;
		setY(a*(float)(Math.sin(time*300f*Math.PI/500)+y));
		*/
		setX(getX() + getVelocidad() * dt);
		//setRectanguloY(getY());
		setRectanguloX(getX());
	}

}
