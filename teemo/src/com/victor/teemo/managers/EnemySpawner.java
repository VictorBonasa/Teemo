package com.victor.teemo.managers;

import java.util.Random;

import com.victor.teemo.characters.Enemy;
import com.victor.teemo.characters.Enemy.tipoDeEnemigo;
import com.victor.teemo.characters.FantasmaAzul;
import com.victor.teemo.characters.FantasmaVerde;
import com.victor.teemo.characters.Seta;
import com.victor.teemo.util.Constantes;

public class EnemySpawner {
	
	float velocidadVerde;
	float velocidadAzul;
	float velocidadSeta;
	
	public static Enemy crearEnemigo(tipoDeEnemigo tipo, SpriteManager spriteManager){
		Enemy enemigo = null;
		
		
		if(tipo == Enemy.tipoDeEnemigo.FANTASMA_AZUL){
			int i = new Random().nextInt(Constantes.SCREEN_ANCHO- Constantes.ANCHURA_ENEMIGO);
			System.out.println("i: "+i);
			enemigo = new FantasmaAzul(i,Constantes.SCREEN_ALTO ,-120f);
		}
		
		if(tipo == Enemy.tipoDeEnemigo.FANTASMA_VERDE){
			int j = new Random().nextInt(Constantes.SCREEN_ALTO- Constantes.ALTURA_ENEMIGO);
			System.out.println("j: "+j);
			enemigo = new FantasmaVerde(Constantes.SCREEN_ANCHO, j,-100f);
		}
		
		if(tipo == Enemy.tipoDeEnemigo.SETA){
			enemigo = new Seta(Constantes.SCREEN_ANCHO, new Random().nextInt(Constantes.SCREEN_ALTO- Constantes.ALTURA_ENEMIGO),-50f);
		}

		
		return enemigo;
		
	}

}
