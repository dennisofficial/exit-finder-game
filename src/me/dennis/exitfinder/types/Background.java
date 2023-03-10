package me.dennis.exitfinder.types;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import me.dennis.exitfinder.core.Camera;
import me.dennis.exitfinder.enums.Image;
import me.dennis.exitfinder.utils.Settings;

public class Background {

	public int x;
	public int y;
	public float vspeed;
	public float hspeed;

	BufferedImage image;
	Color color;
	
	public Background(Image image) {
		this.image = image.getImage();
	}
	
	public Background(Integer hex) {
		color = new Color(hex);
	}
	
	public void draw(Graphics g) {
		if (color != null) {
			g.setColor(color);
			g.fillRect((int) -Camera.x, (int) -Camera.y, Settings.width, Settings.height);
		}
	}
	
}