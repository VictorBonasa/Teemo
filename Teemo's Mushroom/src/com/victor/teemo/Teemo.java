package com.victor.teemo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Teemo extends Game{
	
	OrthographicCamera camara;
	SpriteBatch spriteBatch;
	BitmapFont fuente;
	@Override
	public void create() {
		spriteBatch = new SpriteBatch();
		fuente = new BitmapFont();
		setScreen( new MainMenuScreen(this));
	}
	
	public void render() {
		super.render();
	}
	
	public void dispose() {
		spriteBatch.dispose();
		fuente.dispose();
	}

}
