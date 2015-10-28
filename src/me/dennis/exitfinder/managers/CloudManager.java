package me.dennis.exitfinder.managers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class CloudManager {

	private List<Rectangle> clouds = new ArrayList<Rectangle>();
	
	public void update() {
	}
	
	public void draw(Graphics g) {
		for (Rectangle cloud : clouds) {
			g.setColor(new Color(0xFFFFFF));
			g.fillRect(cloud.x, cloud.y, cloud.width, cloud.height);
		}
	}
	
}
