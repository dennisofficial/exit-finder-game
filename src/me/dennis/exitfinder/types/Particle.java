package me.dennis.exitfinder.types;

import java.awt.Color;
import java.awt.Graphics;

public class Particle {

	int x, y;
	int dx, dy;
	int r, g, b, a;
	
	boolean remove = false;
	
	Color c;
	
	public Particle(int x, int y, int ox, int oy, int dx, int dy, int r, int g, int b, int a) {
		this.x = x + ox;
		this.y = y + oy;
		this.dx = dx;
		this.dy = dy;
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
		c = new Color(r, g, b, a);
	}
	
	public void update() {
		if (a > 0 + 10) {
			a-= 10;
		}
		else {
			remove = true;
		}
		c = new Color(r, g, b, a);
		x += dx;
		y += dy;
	}
	
	public void draw(Graphics g) {
		g.setColor(new Color(r, this.g, b, a));
		g.fillRect(x, y, 5, 5);
	}
	
	public boolean doRemove() {
		return remove;
	}
	
}
