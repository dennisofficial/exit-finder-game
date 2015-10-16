package me.dennis.exitfinder.objects;

import java.awt.Color;
import java.awt.Graphics;

import me.dennis.exitfinder.types.GameObject;

public class Player extends GameObject {

	public Player(Integer x, Integer y) {
		super(x, y);
		width = 50;
		height = 50;
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
		// movement
		x += hspeed;
		y += vspeed;
		// gravity
		vspeed += 0.25;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(0x0));
		g.fillRect((int) x, (int) y, width, height);
	}

}
