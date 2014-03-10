package com.victor.teemo.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.victor.teemo.Teemo;
import com.victor.teemo.characters.TeemoPersonaje;
import com.victor.teemo.managers.LevelManager;
import com.victor.teemo.managers.ResourceManager;
import com.victor.teemo.managers.SpriteManager;

public class GameScreen implements Screen{
	
	Teemo juego;
	
	private SpriteManager spriteManager;
	private LevelManager levelManager;
	
	public enum Nivel{
		UNO,DOS,TRES,CUATRO;
	}
	public Nivel nivel;
	public GameScreen(Teemo juego, Nivel nivel){
		this.juego = juego;
		this.nivel = nivel;
		cargaPantalla();
		ResourceManager.getSound("OnDuty").play();
	}
	
	private void cargaPantalla(){
		ResourceManager.cargarTodo();
		spriteManager = new SpriteManager(juego);
		levelManager = new LevelManager(spriteManager);
		levelManager.leerArchivoNivel(nivel);
	}
	

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		juego.pausa=true;
		
	}

	@Override
	public void pause() {
		juego.pausa=true;
		
	}

	@Override
	public void render(float arg0) {
		
		Gdx.gl.glClearColor(0, 1, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
			
		juego.camera.update();
		
		update(arg0);
		
		juego.batch.begin();
			spriteManager.draw(juego.batch);	
			InfPantalla();
			juego.batch.end();
		
	}
	
	private void InfPantalla(){
		TeemoPersonaje teemoP = spriteManager.getTeemoP();
		juego.font.draw(juego.batch, "Puntos: "+teemoP.getPuntuacion(),15,580 );
		juego.batch.draw(ResourceManager.getTexture("vida"),15,530);
		juego.font.draw(juego.batch, "X " + spriteManager.getTeemoP().getVidas(), 50, 545);
		juego.font.draw(juego.batch, "Nivel: " + levelManager.getNivelActual(), 15, 520);
		
	}
	
	private void update(float dt){
		
		
		switch (nivel) {
		case UNO:
			levelManager.generateRandomLevel(dt);
			break;
		case DOS:
			levelManager.nivelDeArchivo(dt);
			break;
		case TRES:
			levelManager.nivelDeArchivo(dt);
			break;
		case CUATRO:
			levelManager.nivelDeArchivo(dt);
			break;
		default:
		}

		if (!juego.pausa) {
			spriteManager.update(dt);
			spriteManager.getTeemoP().update(dt, spriteManager);
		}
		
		teclado();
	}
	
	private void teclado(){
		if (Gdx.input.isKeyPressed(Keys.P)) {
			juego.setScreen(new InGameMenuScreen(juego, this));
		}
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		juego.pausa=false;
		
	}

	@Override
	public void show() {
		juego.pausa = false;
		
	}
	
	

}
