package com.victor.teemo.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.victor.teemo.Teemo;
import com.victor.teemo.screens.GameScreen.Nivel;
import com.victor.teemo.util.Constantes;

public class MainScreen implements Screen{
	
	Teemo juego;
	Stage stage;
	
	public MainScreen (Teemo game){
		this.juego = game;
	}
	
	@Override
	public void show() {
		stage = new Stage();
		
		Table table = new Table();
		table.setPosition(Constantes.SCREEN_ANCHO/2.5f, Constantes.SCREEN_ALTO/1.5f);
		table.setFillParent(true);
		table.setHeight(600);
		stage.addActor(table);
		
		Label label = new Label("Bienvenido al juego de Teemo",juego.getSkin());
		table.addActor(label);
		
		TextButton btNivel1 = new TextButton("Nivel 1", juego.getSkin());
		btNivel1.setPosition(label.getOriginX(), label.getOriginY()-50);
		btNivel1.setWidth(200);
		btNivel1.setHeight(40);
		btNivel1.addListener(new InputListener(){

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				super.touchUp(event, x, y, pointer, button);
				dispose();
				juego.setScreen(new GameScreen(juego ,Nivel.UNO));
				
			}
			
		});
		table.addActor(btNivel1);
		
		
		TextButton btNivel2 = new TextButton("Nivel 2", juego.getSkin());
		btNivel2.setPosition(label.getOriginX(), label.getOriginY()-100);
		btNivel2.setWidth(200);
		btNivel2.setHeight(40);
		btNivel2.addListener(new InputListener(){

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				super.touchUp(event, x, y, pointer, button);
				dispose();
				juego.setScreen(new GameScreen(juego ,Nivel.DOS));
				
			}
			
		});
		table.addActor(btNivel2);
		
		TextButton btNivel3 = new TextButton("Nivel 3", juego.getSkin());
		btNivel3.setPosition(label.getOriginX(), label.getOriginY()-150);
		btNivel3.setWidth(200);
		btNivel3.setHeight(40);
		btNivel3.setDisabled(true);
		btNivel3.addListener(new InputListener(){

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				super.touchUp(event, x, y, pointer, button);
				dispose();
				juego.setScreen(new GameScreen(juego ,Nivel.TRES));
				
			}
			
		});
		table.addActor(btNivel3);
		
		
		TextButton btConfiguracion = new TextButton("Instrucciones", juego.getSkin());
		btConfiguracion.setPosition(label.getOriginX(), label.getOriginY()-200);
		btConfiguracion.setWidth(200);
		btConfiguracion.setHeight(40);
		btConfiguracion.addListener(new InputListener(){

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				super.touchUp(event, x, y, pointer, button);
				dispose();
				juego.setScreen(new InstructionsScreen(juego));
				
			}
			
		});
		table.addActor(btConfiguracion);
		
		TextButton btSalir = new TextButton("Salir", juego.getSkin());
		btSalir.setPosition(label.getOriginX(), label.getOriginY()-250);
		btSalir.setWidth(200);
		btSalir.setHeight(40);
		btSalir.addListener(new InputListener(){

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				super.touchUp(event, x, y, pointer, button);
				System.exit(0);
				
			}
			
		});
		table.addActor(btSalir);
		
		Gdx.input.setInputProcessor(stage);
		
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



}
