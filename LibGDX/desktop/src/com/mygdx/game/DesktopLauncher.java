package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

import java.util.Scanner;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("My GDX Game");
			/*Scanner s = new Scanner(System.in);
			System.out.println("input the x resolution:");
			int xRes = s.nextInt();
			System.out.println("input the y resolution");
			int yRes = s.nextInt();
			config.setWindowedMode(xRes, yRes);
			*/
		config.setWindowedMode(800, 500);

		new Lwjgl3Application(new MyGdxGame(), config);
	}
}
