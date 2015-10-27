package me.dennis.exitfinder.managers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import me.dennis.exitfinder.core.Camera;
import me.dennis.exitfinder.utils.Settings;

public class CloudManager {

	private List<Rectangle> clouds = new ArrayList<Rectangle>();
	
	public void update() {
		for (Rectangle cloud : clouds) {
			cloud.x++;
		}
	}
	
	public void draw(Graphics g) {
		for (Rectangle cloud : clouds) {
			g.setColor(new Color(0xFFFFFF));
			g.fillRect(cloud.x, cloud.y, cloud.width, cloud.height);
		}
	}
	
	public void createClouds() {
		Integer amount = new SecureRandom().nextInt(15) + 10;
		for (int i = 0; i < amount; i++) {
			Integer x = new SecureRandom().nextInt(Settings.width);
			Integer y = new SecureRandom().nextInt(Settings.height);
			Integer width = new SecureRandom().nextInt(10) + 4;
			Integer height = new SecureRandom().nextInt(5) + 2;
			
			Rectangle cloud = new Rectangle((int) -Camera.x - (Settings.width/2) + x, (int) -Camera.y - (Settings.height/2) + y, 32 * width, 32 * height);
			clouds.add(cloud);
		}
	}
	
}
