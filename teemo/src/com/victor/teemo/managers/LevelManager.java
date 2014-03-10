package com.victor.teemo.managers;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.victor.teemo.screens.GameScreen.Nivel;
import com.victor.teemo.util.Constantes;
import com.victor.teemo.characters.Enemy;
import com.victor.teemo.characters.Enemy.tipoDeEnemigo;;

public class LevelManager {
	
	private static float PASO = 9f;
	
	private int nivelActual;
	private SpriteManager spriteManager;
	private float enemigoTiempo;
	private Random aleatorio;
	
	private float pasoTiempo;
	private int pasoActual;
	private boolean pasoHecho;
	private String[] pasos;
	
	public LevelManager(SpriteManager spriteManager){
		this.spriteManager = spriteManager;
		nivelActual = 1;
		enemigoTiempo =0;
		aleatorio= new Random();
	}

	
	public void generateRandomLevel(float dt) {
		
		Enemy enemy = null;
		nivelActual = 1;
		enemigoTiempo += dt;
		if (enemigoTiempo > 1) {
			int i = aleatorio.nextInt(tipoDeEnemigo.values().length);
			
			enemy = EnemySpawner.crearEnemigo(tipoDeEnemigo.values()[i], spriteManager);
			
			spriteManager.getEnemigos().add(enemy);
			enemigoTiempo = 0;
		}
	}
	
	public void leerArchivoNivel(Nivel nivel){
		
		
		//No hay nivel 1, el nivel 1 es aleatorio y no generado de fichero
		if(nivel.equals(Nivel.UNO)){
			nivelActual = 2;
		}
		if(nivel.equals(Nivel.DOS)){
			nivelActual = 2;
		}
		if(nivel.equals(Nivel.TRES)){
			nivelActual = 3;
		}
		if(nivel.equals(Nivel.CUATRO)){
			nivelActual = 4;
		}
		
		
		FileHandle file =Gdx.files.internal("Niveles/Nivel"+nivelActual+".txt");
		String informacionNivel = file.readString();
		
		pasos = informacionNivel.split("\n");
		
	}
	
	public void nivelDeArchivo(float dt){
		
		Array<Enemy> enemigos = spriteManager.getEnemigos();
		
		enemigoTiempo +=dt;
		pasoTiempo +=dt;
		
		if(pasoTiempo >= PASO){
			
			pasoActual++;
			pasoTiempo=0;
			pasoHecho = false;
			
		}
		
		if(pasoActual >pasos.length-1)
			return;
		
		if(!pasoHecho){
			String []lineas = pasos[pasoActual].split(",");
			
			for(String linea:lineas){
				String[]datos = linea.split(" ");
				enemigos.add(EnemySpawner.CrearEnemigoArchivo(tipoDeEnemigo.valueOf(datos[0].trim()), Float.parseFloat(datos[1].trim()), Float.parseFloat(datos[2].trim()), spriteManager));
				pasoHecho = true;
			}
			
		}
		
	}


	public int getNivelActual() {
		return nivelActual;
	}


	public void setNivelActual(int nivelActual) {
		this.nivelActual = nivelActual;
	}
	

}
