package com.victor.teemo.characters;

import com.badlogic.gdx.math.Rectangle;
import com.victor.teemo.managers.ResourceManager;
import com.victor.teemo.util.Constantes;

public class FantasmaVerde extends Enemy{

	public FantasmaVerde(float x, float y, float velocidad) {
		super(x, y, velocidad);

		animacion = ResourceManager.getAnimation("fantasmaVerde");
		setRectangulo(new Rectangle(x,y, Constantes.ANCHURA_ENEMIGO, Constantes.ALTURA_ENEMIGO));
		setPuntosValor(5);
		setVidas(1);
	}
	
	@Override
	public void update(float dt) {
		
		super.update(dt);
		
		setX(getX() + getVelocidad() * dt);
		setRectanguloX(getX());
	}

}
