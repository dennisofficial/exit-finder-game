package me.dennis.exitfinder.managers;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import me.dennis.exitfinder.types.Cloud;
import me.dennis.exitfinder.utils.Settings;

public class CloudManager {

	private List<Cloud> clouds = new ArrayList<Cloud>();
	
	public void init() {
		for (int x = 0; x < Settings.height; x += Settings.height / 5) {
			for (int y = 0; y < Settings.width; y += Settings.width / 5) {
				clouds.add(new Cloud(x, y, this));
			}
		}
	}
	
	public void update() {
		for (Cloud cloud : clouds) {
			cloud.update();
		}
	}
	
	public void draw(Graphics g) {
		for (Cloud cloud : clouds) {
			cloud.draw(g);
		}
	}
	
	public void destroy(Cloud cloud) {
		clouds.remove(cloud);
	}
	
}
