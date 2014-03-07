package com.victor.teemo.managers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.victor.teemo.Teemo;
import com.victor.teemo.characters.Enemy;
import com.victor.teemo.characters.TeemoPersonaje;
import com.victor.teemo.screens.GameOverScreen;
import com.victor.teemo.util.Constantes;

public class SpriteManager {
	private Teemo juego;
	private Texture fondo;
	private TeemoPersonaje teemoP;
	private Array<Enemy> enemigos;
	
	
	public SpriteManager (Teemo juego){
		fondo = ResourceManager.getTexture("fondo");
		teemoP = new TeemoPersonaje(50,50,250,juego.configurationManager);
		teemoP.setVidas(Constantes.VIDAS);
		enemigos = new Array<Enemy>();
		this.juego = juego;
	}
	
	public void update(float dt){
		upEnemigos(dt);
		checkColisiones(dt);
	}
	
	private void upEnemigos(float dt){
		
		for(int i=enemigos.size-1;i>=0;i--){
			Enemy enemigo = enemigos.get(i);
			enemigo.update(dt);
			
			if((enemigo.getX()<0)||(enemigo.getY()<0)){
				enemigos.removeIndex(i);
			}
		}
		
	}
	
	public void draw(SpriteBatch batch){
		batch.disableBlending();
		batch.draw(fondo, 0,0);
		batch.enableBlending();
		teemoP.draw(batch);
		
		for(Enemy enemigo:enemigos){
			enemigo.draw(batch);
		}
		
	}
	
	public void checkColisiones(float dt){
		Enemy enemigo = null;
		
		for(int i= enemigos.size-1;i>=0; i--){
			enemigo = enemigos.get(i);
			
			if(enemigo.getRectangulo().overlaps(teemoP.getRectangulo())){
				
				if(enemigo.getClass().getSimpleName().equals("Seta")){
					enemigo.hit();
					if(enemigo.getVidas()==0){
						teemoP.setPuntuacion(teemoP.getPuntuacion()+enemigo.getPuntosValor());
						enemigos.removeIndex(i);
					}
					
					
				}
				
				if(enemigo.getClass().getSimpleName().equals("FantasmaAzul")){
					enemigo.hit();
					if(enemigo.getVidas()==0){
						teemoP.setPuntuacion(teemoP.getPuntuacion()+enemigo.getPuntosValor());
						enemigos.removeIndex(i);
					}
					teemoP.hit();
					ResourceManager.getSound("ataque2").play();
					if (teemoP.getVidas() == 0) {
						juego.puntuacion = teemoP.getPuntuacion();
						juego.setScreen(new GameOverScreen(juego));
					}
					
				}

				if(enemigo.getClass().getSimpleName().equals("FantasmaVerde")){
					enemigo.hit();
					if(enemigo.getVidas()==0){
						teemoP.setPuntuacion(teemoP.getPuntuacion()+enemigo.getPuntosValor());
						enemigos.removeIndex(i);
					}
					teemoP.hit();
					ResourceManager.getSound("ataque2").play();
					if (teemoP.getVidas() == 0) {
						juego.puntuacion = teemoP.getPuntuacion();
						juego.setScreen(new GameOverScreen(juego));
					}
	
				}
				
			}
		}
	}

	public Teemo getJuego() {
		return juego;
	}

	public void setJuego(Teemo juego) {
		this.juego = juego;
	}

	public Texture getFondo() {
		return fondo;
	}

	public void setFondo(Texture fondo) {
		this.fondo = fondo;
	}

	public TeemoPersonaje getTeemoP() {
		return teemoP;
	}

	public void setTeemoP(TeemoPersonaje teemoP) {
		this.teemoP = teemoP;
	}

	public Array<Enemy> getEnemigos() {
		return enemigos;
	}

	public void setEnemigos(Array<Enemy> enemigos) {
		this.enemigos = enemigos;
	}
	
	
}
