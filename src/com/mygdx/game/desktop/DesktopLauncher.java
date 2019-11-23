package com.mygdx.game.desktop;

import Config.Reloj;
import Game.Game;
import Game.Home;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.title = "Disenio";
                config.height = 1000;
                config.width = 1200;
                Reloj r = new Reloj(1,1);
		new LwjglApplication(new Game(r,new Home()), config);
	}
}
