package com.victor.teemo;

import com.victor.teemo.managers.ConfigurationManger;
import com.victor.teemo.screens.MainScreen;
import com.victor.teemo.util.Constantes;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Teemo extends Game{
	
	private Skin skin;
	public OrthographicCamera camera;
	public SpriteBatch batch;
	public BitmapFont font;
	public int puntuacion;
	public boolean pausa;
	
	public ConfigurationManger configurationManager;

	@Override
	public void create() {
		
		configurationManager = new ConfigurationManger();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Constantes.SCREEN_ANCHO, Constantes.SCREEN_ALTO);
		camera.update();
		
		batch = new SpriteBatch();
		font = new BitmapFont();
		
		setScreen(new MainScreen(this));
	}
	
	public Skin getSkin(){
		if(skin== null){
			skin = new Skin(Gdx.files.internal("UI/uiskin.json"));
		}
		return skin;
	}

}
