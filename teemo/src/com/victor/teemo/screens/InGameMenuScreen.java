package com.victor.teemo.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.victor.teemo.Teemo;
import com.victor.teemo.util.Constantes;

public class InGameMenuScreen implements Screen{
	
	Teemo juego;
	GameScreen gameScreen;
	Stage stage;
	
	public InGameMenuScreen(Teemo juego, GameScreen gameScreen){
		this.juego = juego;
		this.gameScreen = gameScreen;
	}
	@Override
	public void dispose() {
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
	public void render(float arg0) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(arg0);
		stage.draw();
	}
	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void show() {
		stage = new Stage();
		Table tabla = new Table();
		tabla.setPosition(Constantes.SCREEN_ANCHO/2.5f, Constantes.SCREEN_ALTO/1.5f);
		tabla.setFillParent(true);
		tabla.setHeight(500);
		stage.addActor(tabla);
		
		TextButton btContinuar = new TextButton("Continuar", juego.getSkin());
		//btContinuar.setPosition(label.getOriginX(), label.getOriginY() - 120);
		btContinuar.setWidth(200);
		btContinuar.setHeight(40);
		btContinuar.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				dispose();
				juego.setScreen(gameScreen);
			}
	
		});
		tabla.addActor(btContinuar);
		
		TextButton btMenu = new TextButton("Menu Principal", juego.getSkin());
		btMenu.setPosition(btContinuar.getOriginX(), btContinuar.getOriginY() - 100);
		btMenu.setWidth(200);
		btMenu.setHeight(40);
		btMenu.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				dispose();
				juego.setScreen(new MainScreen(juego));
			}

		});
		tabla.addActor(btMenu);
		
		TextButton btSalir = new TextButton("Salir", juego.getSkin());
		btSalir.setPosition(btContinuar.getOriginX(), btContinuar.getOriginY() - 150);
		btSalir.setWidth(200);
		btSalir.setHeight(40);
		btSalir.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				System.exit(0);
			}
		
		});
		tabla.addActor(btSalir);
		
		Gdx.input.setInputProcessor(stage);
		
	}

}
