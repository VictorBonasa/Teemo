package com.victor.teemo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class EndScreen implements Screen {
	
	final Teemo juego;
	OrthographicCamera camara;
	long setas;
	long vida;
	Sound sonidoDefeat;
	
	public EndScreen(Teemo juego, long setas){
		this.juego = juego;
		this.setas = setas;
		camara = new OrthographicCamera();
		camara.setToOrtho(false, 1024, 768);
		
		sonidoDefeat = Gdx.audio.newSound(Gdx.files.internal("Female1_OnDefeat_1.ogg"));
		sonidoDefeat.play();
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		camara.update();
		juego.spriteBatch.setProjectionMatrix(camara.combined);
		
		juego.spriteBatch.begin();
		juego.fuente.draw(juego.spriteBatch, "Fin del Juego", 400, 400);
		juego.fuente.draw(juego.spriteBatch, "Puntuacion Final: " + setas , 400, 384);
		juego.spriteBatch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}