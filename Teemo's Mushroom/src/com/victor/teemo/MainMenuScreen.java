package com.victor.teemo;

import com.victor.teemo.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

public class MainMenuScreen implements Screen {
	
	final Teemo juego;
	int skin;
	Texture spriteOriginalSkin;
	Texture spriteAstronautSkin;
	Music musicaOnDuty;
	
	OrthographicCamera camara;
	
	public MainMenuScreen(Teemo juego){
		this.juego = juego;
		camara = new OrthographicCamera();
		camara.setToOrtho(false, 1024, 786);
		spriteOriginalSkin = new Texture(Gdx.files.internal("OriginalSkin.jpg")); 
		spriteAstronautSkin = new Texture(Gdx.files.internal("AstronautSkin.jpg")); 
		
		musicaOnDuty = Gdx.audio.newMusic(Gdx.files.internal("OnDuty.mp3"));
		musicaOnDuty.play();
		musicaOnDuty.setLooping(true);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		camara.update();
		juego.spriteBatch.setProjectionMatrix(camara.combined);
		
		// Muestra un menú de inicio
		juego.spriteBatch.begin();
		juego.fuente.draw(juego.spriteBatch, "Bienvenido al Juego de las Setas de Teemo!", 400, 700);
		//juego.fuente.draw(juego.spriteBatch, "Pulsa para empezar", 100, 120);
		juego.fuente.draw(juego.spriteBatch, "Selecciona una Skin", 400, 200);
		juego.spriteBatch.draw(spriteOriginalSkin, 500, 500);
		juego.spriteBatch.draw(spriteAstronautSkin, 500, 400);
		juego.spriteBatch.end();
		
		/*
		 * Si el usuario toca la pantalla se inicia la partida
		 */
		
		if (Gdx.input.isTouched()) {
			if(Gdx.input.getX()> 500 && Gdx.input.getX()<559 && Gdx.input.getY() > 220 && Gdx.input.getY()< 275) {
				skin = 1;
				juego.setScreen(new GameScreen(juego, skin));
				dispose();
			}
			
			if(Gdx.input.getX()> 503 && Gdx.input.getX()<561 && Gdx.input.getY() > 317 && Gdx.input.getY()< 376) {
				skin = 2;
				juego.setScreen(new GameScreen(juego, skin));
				dispose();
			}
		}
		
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
