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
import com.victor.teemo.util.Constantes;

public class GameOverScreen implements Screen{
	
	Teemo juego;
	Stage stage;
	
	
	public GameOverScreen(Teemo juego){
		this.juego = juego;
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
		
		final Table table = new Table();
		table.setPosition(Constantes.SCREEN_ANCHO/2.5f, Constantes.SCREEN_ALTO/1.5f);
		table.setFillParent(true);
		table.setHeight(500);
		stage.addActor(table);
		
		Label lbPuntuacion = new Label("Tu puntuacion es: "+juego.puntuacion, juego.getSkin());
		//lbPuntuacion.setPosition(lb, y);
		table.addActor(lbPuntuacion);
		
		TextButton btMenuPrincipal = new TextButton("Menu Principal", juego.getSkin());
		btMenuPrincipal.setPosition(lbPuntuacion.getOriginX(), lbPuntuacion.getOriginY()-300);
		btMenuPrincipal.setWidth(200);
		btMenuPrincipal.setHeight(40);
		btMenuPrincipal.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				juego.setScreen(new MainScreen(juego));
			}
			
			
			
		});
		table.addActor(btMenuPrincipal);
		
		Gdx.input.setInputProcessor(stage);
	}

}
