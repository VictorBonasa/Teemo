package com.victor.teemo;

import java.util.Iterator;

import com.victor.teemo.EndScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class GameScreen implements Screen{
	
	final Teemo juego;
	
	Texture spriteDardo;
	Texture spriteSeta;
	Texture spriteDemonio;
	Texture spriteTeemo;
	
	Rectangle dardo = new Rectangle();;
	Rectangle seta;
	Rectangle demonio;
	Rectangle teemo;
	
	Array<Rectangle> dardos;
	Array<Rectangle> setas;
	Array<Rectangle> demonios;
	
	long ultimoDardo;
	long ultimoSeta;
	long ultimoDemonio;
	
	Sound sonidoFrase1;
	Sound sonidoFrase2;
	Sound sonidoFrase3;
	Sound sonidoPenta;
	Music musicaRisa;
	
	long demoniosAsesinados;
	long setasRecogidas;
	long vida = 5;
	
	int skin;
	
	Iterator<Rectangle> iterDardos;
	Iterator<Rectangle> iterSetas;
	Iterator<Rectangle> iterDemonios;
	
	OrthographicCamera camara;
	
	public GameScreen(Teemo juego, int skin){
		this.juego = juego;
		this.skin = skin;
		
		Texture.setEnforcePotImages(false);
		
		spriteDardo = new Texture (Gdx.files.internal("Toxic_Shot2.png"));
		spriteSeta = new Texture (Gdx.files.internal("mushroom1.png"));
		spriteDemonio = new Texture (Gdx.files.internal("yoricghouls1.png"));
		
		if(this.skin == 1){
			spriteTeemo = new Texture (Gdx.files.internal("Teemo_OriginalLoading.png"));
			sonidoFrase1 = Gdx.audio.newSound(Gdx.files.internal("Teemo.ogg"));
			sonidoFrase2 = Gdx.audio.newSound(Gdx.files.internal("Teemo.attack4.ogg"));
			sonidoFrase3 = Gdx.audio.newSound(Gdx.files.internal("Teemo.joke.ogg"));
			musicaRisa = Gdx.audio.newMusic(Gdx.files.internal("Teemo.laugh1.ogg"));
			
		}else{
			spriteTeemo = new Texture (Gdx.files.internal("Teemo_AstronautLoading.jpg"));
			sonidoFrase1 = Gdx.audio.newSound(Gdx.files.internal("AstronautTeemo.attack1.ogg"));
			sonidoFrase2 = Gdx.audio.newSound(Gdx.files.internal("AstronautTeemo.attack4.ogg"));
			sonidoFrase3 = Gdx.audio.newSound(Gdx.files.internal("AstronautTeemo.joke.ogg"));
			musicaRisa = Gdx.audio.newMusic(Gdx.files.internal("AstronautTeemo.laugh1.ogg"));
			
		}
		
		
		
		sonidoPenta = Gdx.audio.newSound(Gdx.files.internal("Female1_OnChampionPentaKillYo1.ogg"));
		
		if(setasRecogidas== 5f || setasRecogidas == 10f || setasRecogidas == 15f){
			sonidoPenta.play();
		}
		
		
		teemo = new Rectangle();
		teemo.x = 1024 / 2 - 64 / 2;
		teemo.y = 20;
		teemo.width = 64;
		teemo.height = 64;
		
		setas = new Array<Rectangle>();
		generarSetas();
		demonios = new Array<Rectangle>();
		generarDemonios();
		dardos = new Array<Rectangle>();
		
		camara = new OrthographicCamera();
		camara.setToOrtho(false, 1024, 768);
		
	}
	

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		camara.update();
		
		
		juego.spriteBatch.setProjectionMatrix(camara.combined);
		juego.spriteBatch.begin();
		juego.spriteBatch.draw(spriteTeemo, teemo.x, teemo.y);

		for (Rectangle seta : setas)
			juego.spriteBatch.draw(spriteSeta, seta.x, seta.y);
		
		for(Rectangle demonio : demonios)
			juego.spriteBatch.draw(spriteDemonio, demonio.x, demonio.y);
		
		for (Rectangle dardo : dardos){
			juego.spriteBatch.draw(spriteDardo, dardo.x, dardo.y);
		}
		
		juego.fuente.draw(juego.spriteBatch, setasRecogidas + " Setas Recogidas", 1024 - 200, 768 - 50);
		juego.fuente.draw(juego.spriteBatch, demoniosAsesinados + " Demonios Asesinados", 1024 - 200, 768 - 75);
		juego.fuente.draw(juego.spriteBatch, vida +" vida", 1024 - 200, 768 - 100);
		juego.spriteBatch.end();
		
		if (Gdx.input.isTouched()) {
			Vector3 posicion = new Vector3();
			posicion.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			/*
			 * Transforma las coordenadas de la posición
			 * al sistema de coordenadas de la cámara
			 */
			camara.unproject(posicion);
			teemo.x = posicion.x - 64 /2;
			teemo.y = posicion.y - 64 /2;
		}
		
		if (Gdx.input.isKeyPressed(Keys.UP))
			teemo.y += 20000 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Keys.DOWN))
			teemo.y -= 20000 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Keys.LEFT))
			teemo.x -= 20000 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Keys.RIGHT))
			teemo.x += 20000 * Gdx.graphics.getDeltaTime();
		
		if (teemo.x < 0)
			teemo.x = 0;
		if (teemo.x > 1024 - 64)
			teemo.x = 1024 - 64;
		
		if (TimeUtils.nanoTime() - ultimoSeta > 100000000)
			generarSetas();
		
		if (TimeUtils.nanoTime() - ultimoDemonio > 199999999){
			generarDemonios();
			
		}
		
		if(Gdx.input.isKeyPressed(Keys.ENTER)){
			if (TimeUtils.nanoTime() - ultimoDardo > 1000000000)
				lanzarDardo();
				sonidoFrase2.pause();
				sonidoFrase2.play();
		}
		iterDardos = dardos.iterator();
			while(iterDardos.hasNext()){
				Rectangle dardo = iterDardos.next();
				dardo.y += 300 * Gdx.graphics.getDeltaTime();
				
				if(dardo.y > 700){
					iterDardos.remove();
				}
				/*
				if(dardo.overlaps(seta)){
					iterDardos.remove();
				}
				*/
			}
			
			iterSetas = setas.iterator();
			while (iterSetas.hasNext()) {
				seta = iterSetas.next();
				seta.y -= 200 * Gdx.graphics.getDeltaTime();
				if (seta.y + 64 < 0)
					iterSetas.remove();
				if (seta.overlaps(teemo)) {
					sonidoFrase1.pause();
					sonidoFrase1.play();
					iterSetas.remove();
					setasRecogidas++;
				}
			}
			
			
			iterDemonios = demonios.iterator();
			while(iterDemonios.hasNext()){
				Rectangle demonio = iterDemonios.next();
				demonio.y -= 200 * Gdx.graphics.getDeltaTime();
				if(demonio.y + 64 < 0)
					iterDemonios.remove();
				
				if(demonio.overlaps(dardo)){
					demoniosAsesinados++;
					iterDemonios.remove();
				}
				
				if(demonio.overlaps(teemo)){
					sonidoFrase3.pause();
					sonidoFrase3.play();
					iterDemonios.remove();
					vida--;
					
					if(vida <= 0){
						juego.setScreen(new EndScreen(juego, setasRecogidas+(demoniosAsesinados*10)));
						dispose();
					}
				}
			}
	}
	
	private void generarSetas() {
		seta = new Rectangle();
		seta.x = MathUtils.random(0, 1024 - 64);
		seta.y = 768;
		seta.width = 64;
		seta.height = 64;
		setas.add(seta);
		ultimoSeta = TimeUtils.nanoTime();
	}
	
	private void generarDemonios(){
		demonio = new Rectangle();
		demonio.x = MathUtils.random(0, 1024 - 64);
		demonio.y = 768;
		demonio.width = 64;
		demonio.height = 64;
		demonios.add(demonio);
		ultimoDemonio = TimeUtils.nanoTime();
	}
	
	private void lanzarDardo(){
		dardo = new Rectangle();
		dardo.x = Gdx.input.getX();
		dardo.y = 0;
		dardo.width = 64;
		dardo.height = 64;
		dardos.add(dardo);
		ultimoDardo = TimeUtils.nanoTime();
	}
	

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		musicaRisa.play();
		
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
		spriteDardo.dispose();
		spriteSeta.dispose();
		spriteDemonio.dispose();
		spriteTeemo.dispose();
		musicaRisa.dispose();
		
	}

}
