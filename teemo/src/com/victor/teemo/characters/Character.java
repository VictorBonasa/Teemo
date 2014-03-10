package com.victor.teemo.characters;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Disposable;

public abstract class Character implements Disposable{
	
	public float velocidad;
	private int puntuacion;
	private int vidas;
	
	public float x;
	public float y;
	private Rectangle rectangulo;
	public Animation animacion;
	public float stateTime;
	public TextureRegion frameActual;
	
	public enum Direction {
		LEFT, RIGHT
	}
	
	public Character(float x, float y) {
		velocidad = 400f;
		puntuacion = 0;
		vidas = 3;
		
		this.x = x;
		this.y = y;
	}
	
	public Character(float x, float y, float velocidad) {

		puntuacion = 0;
		vidas = 3;
		
		this.velocidad = velocidad;
		this.x = x;
		this.y = y;
	}
	
	// Recibe un impacto
		public void hit() {
			vidas--;
		}
		
		// Dibuja en pantalla el personaje
		public abstract void draw(SpriteBatch batch);
		
		public void die() {}


	@Override
	public void dispose() {
		rectangulo = null;
		animacion = null;
		
	}

	public float getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}

	public int getPuntos() {
		return puntuacion;
	}

	public void setPuntos(int puntos) {
		this.puntuacion = puntos;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Rectangle getRectangulo() {
		return rectangulo;
	}

	public void setRectangulo(Rectangle rectangulo) {
		this.rectangulo = rectangulo;
	}
	
	public float getRectanguloX(){
		return rectangulo.getX();
	}
	
	public void setRectanguloX(float x){
		rectangulo.setX(x);
		
	}
	
	public float getRectanguloY(){
		return rectangulo.getY();
	}
	
	public void setRectanguloY(float y){
		rectangulo.setY(y);
		
	}

	public Animation getAnimacion() {
		return animacion;
	}

	public void setAnimacion(Animation animacion) {
		this.animacion = animacion;
	}

	public float getStateTime() {
		return stateTime;
	}

	public void setStateTime(float stateTime) {
		this.stateTime = stateTime;
	}

	public TextureRegion getFrameActual() {
		return frameActual;
	}

	public void setFrameActual(TextureRegion frameActual) {
		this.frameActual = frameActual;
	}
	

}
