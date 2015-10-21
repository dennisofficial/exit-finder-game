package me.dennis.exitfinder.types;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	public double x;
	public double y;
	public int width;
	public int height;
	public int metadata;
	public float hspeed;
	public float vspeed;
	public Rectangle bounds;
	
	public GameObject(Integer x, Integer y, Integer meta) {
		this.x = x;
		this.y = y;
		metadata = meta;
		bounds = new Rectangle(x, y, width, height);
	}

	public void velocity() {
		x += hspeed;
		y += vspeed;
		bounds = new Rectangle((int) x, (int) y, width, height);
	}
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics g);
	
	public boolean isSolid() {
		return false;
	}
	
}
