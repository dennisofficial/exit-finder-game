package me.dennis.exitfinder.objects;

import java.awt.Color;
import java.awt.Graphics;

import me.dennis.exitfinder.types.GameObject;

public class Elevator extends GameObject {

	Direction TO = Direction.TO;
	Direction BACK = Direction.BACK;
	
	int top, bot;
	int speed = 2;
	Direction dir = TO;
	
	public Elevator(Integer x, Integer y) {
		super(x, y);
		width = 32;
		height = 16;
		top = y - 128;
		bot = y;
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
		if (dir.equals(TO)) {
			if (y > top) {
				y -= speed;
			}
			else {
				dir = BACK;
			}
		}
		if (dir.equals(BACK)) {
			if (y < bot) {
				y += speed;
			}
			else {
				dir = TO;
			}
		}
		// COLLISION CHECK FOR PLAYER
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(0xFFACAC));
		g.fillRect((int) x, (int) y, width, height);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
	
}

enum Direction { TO, BACK }