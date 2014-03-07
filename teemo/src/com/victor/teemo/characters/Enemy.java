package com.victor.teemo.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Enemy extends Character{
	
	public enum tipoDeEnemigo{
		FANTASMA_VERDE, FANTASMA_AZUL,SETA
	}
	
	private int puntosValor;
	
	public Enemy(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public Enemy(float x, float y, float velocidad) {
		super(x, y, velocidad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(frameActual, getX(), getY());
		
	}
	
	public void update(float dt) {
		
		stateTime += Gdx.graphics.getDeltaTime();
		frameActual = animacion.getKeyFrame(stateTime, true);
	}

	public int getPuntosValor() {
		return puntosValor;
	}

	public void setPuntosValor(int puntosValor) {
		this.puntosValor = puntosValor;
	}
	
	

}
