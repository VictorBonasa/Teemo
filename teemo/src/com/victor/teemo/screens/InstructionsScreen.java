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

public class InstructionsScreen implements Screen{
	Teemo juego;
	Stage stage;
	
	public InstructionsScreen(Teemo juego){
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
		
		Table table = new Table();
		table.setPosition(Constantes.SCREEN_ANCHO-750f, Constantes.SCREEN_ALTO-50f);
		table.setFillParent(true);
		table.setHeight(600);
		stage.addActor(table);
		
		Label label = new Label("Instrucciones de juego",juego.getSkin());
		table.addActor(label);
		Label label2 = new Label("Utiliza W,A,S,D para moverte",juego.getSkin());
		label2.setPosition(label.getOriginX(), label.getOriginY()-50);
		table.addActor(label2);
		Label label3= new Label("El objetivo es recoger el mayor numero de setas, los \n fantasmas tambien dan puntos, pero restan vidas",juego.getSkin());
		label3.setPosition(label.getOriginX(), label.getOriginY()-100);
		table.addActor(label3);
		
		Label label4= new Label("Los fantasmas azules dan 10 puntos pero hacen 2 vidas de da�o",juego.getSkin());
		label4.setPosition(label.getOriginX(), label.getOriginY()-150);
		table.addActor(label4);
		
		Label label5= new Label("Los fantasmas verdes dan 5 puntos y te hacen 1 vida de da�o \n Cada seta vale 50 puntos",juego.getSkin());
		label5.setPosition(label.getOriginX(), label.getOriginY()-200);
		table.addActor(label5);
		
		
		
		TextButton btmenuPrincipal = new TextButton("Menu Principal", juego.getSkin());
		btmenuPrincipal.setPosition(label.getOriginX(), label.getOriginY()-500);
		btmenuPrincipal.setWidth(200);
		btmenuPrincipal.setHeight(40);
		btmenuPrincipal.setDisabled(true);
		btmenuPrincipal.addListener(new InputListener(){

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
				juego.setScreen(new MainScreen(juego));
				
			}
			
		});
		table.addActor(btmenuPrincipal);
		
		Gdx.input.setInputProcessor(stage);
		
	}

}
