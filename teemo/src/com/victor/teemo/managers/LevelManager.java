package com.victor.teemo.managers;

import java.util.Random;
import com.victor.teemo.util.Constantes;

import com.victor.teemo.characters.Enemy;
import com.victor.teemo.characters.Enemy.tipoDeEnemigo;;

public class LevelManager {
	
	private static float STEP = 9f;
	
	private int nivelActual;
	private SpriteManager spriteManager;
	private float enemigoTiempo;
	private Random aleatorio;
	
	public LevelManager(SpriteManager spriteManager){
		this.spriteManager = spriteManager;
		nivelActual = 1;
		enemigoTiempo =0;
		aleatorio= new Random();
	}

	
	public void generateRandomLevel(float dt) {
		
		Enemy enemy = null;
		
		enemigoTiempo += dt;
		//TOOD cambiar el 1 por ENEMY_RATE de constantes
		if (enemigoTiempo > 1) {
			
			// Genera los enemigos aleatoriamente
			int i = aleatorio.nextInt(tipoDeEnemigo.values().length);
			
			enemy = EnemySpawner.crearEnemigo(tipoDeEnemigo.values()[i], spriteManager);
			
			spriteManager.getEnemigos().add(enemy);
			enemigoTiempo = 0;
		}
	}

}
