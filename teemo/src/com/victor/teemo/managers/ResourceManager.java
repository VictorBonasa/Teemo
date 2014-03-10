package com.victor.teemo.managers;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ResourceManager {
	private static Map<String, Texture> texturas = new HashMap<String, Texture>();
	private static Map<String, Animation> animaciones = new HashMap<String, Animation>();
	private static Map<String, Sound> sonidos = new HashMap<String, Sound>();
	
	public static void cargarTodo(){
		Texture.setEnforcePotImages(false);
		
		cargarTextura("fondo", new Texture("fondo/sky_background1.jpg"));
		
		cargarTextura("vida", new Texture("Items/vidaSprite.png"));
		
		//cargarTextura("teemo", new Texture("Personaje/teemoDerecha.png"));
		
		cargarAnimacion("teemo", new Animation(0.20f, new TextureRegion[]{
				new Sprite(new Texture(Gdx.files.internal("Personaje/teemoDerecha.png"))),
				new Sprite(new Texture(Gdx.files.internal("Personaje/teemoIzquierda.png")))
		}));
		cargarAnimacion("fantasmaVerde", new Animation(0.20f, new TextureRegion[]{
				new Sprite(new Texture(Gdx.files.internal("Enemigos/fantasmaVerde1.png"))),
				new Sprite(new Texture(Gdx.files.internal("Enemigos/fantasmaVerde2.png")))
		}));
		cargarAnimacion("fantasmaAzul", new Animation(0.20f, new TextureRegion[]{
				new Sprite(new Texture(Gdx.files.internal("Enemigos/fantasmaAzul1.png"))),
				new Sprite(new Texture(Gdx.files.internal("Enemigos/fantasmaAzul2.png")))
		}));
		cargarAnimacion("seta", new Animation(0.20f, new TextureRegion[]{
				new Sprite(new Texture(Gdx.files.internal("Items/mushroom1.png"))),
				new Sprite(new Texture(Gdx.files.internal("Items/mushroom2.png")))
		}));
		
		cargarSonido("OnDuty", Gdx.audio.newSound(Gdx.files.internal("Sonidos/OnDuty.mp3")));
		cargarSonido("ataque1", Gdx.audio.newSound(Gdx.files.internal("Sonidos/AstronautTeemo.attack1.ogg")));
		cargarSonido("ataque2", Gdx.audio.newSound(Gdx.files.internal("Sonidos/AstronautTeemo.attack2.ogg")));
		cargarSonido("risa", Gdx.audio.newSound(Gdx.files.internal("Sonidos/Teemo.laugh3.ogg")));
		
	}
	
	public static void cargarTextura(String nombre, Texture textura){
		texturas.put(nombre, textura);
		
	}
	public static void cargarAnimacion(String nombre, Animation animacion){
		animaciones.put(nombre, animacion);
		
	}
	public static void cargarSonido(String nombre, Sound sonido){
		sonidos.put(nombre, sonido);
		
	}
	
	public static Texture getTexture(String nombre){
		return texturas.get(nombre);
	}
	
	public static Animation getAnimation(String nombre){
		return animaciones.get(nombre);
	}
	public static Sound getSound(String nombre){
		return sonidos.get(nombre);
	}

}
