package me.dennis.exitfinder.types;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	public double x;
	public double y;
	public int width;
	public int height;
	public float hspeed;
	public float vspeed;
	public Rectangle bounds;
	
	public GameObject(Integer x, Integer y) {
		this.x = x;
		this.y = y;
		bounds = new Rectangle(x, y, width, height);
	}
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics g);
	
}
