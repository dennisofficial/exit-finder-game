package me.dennis.exitfinder.objects;

import java.awt.Color;
import java.awt.Graphics;

import me.dennis.exitfinder.core.Game;
import me.dennis.exitfinder.managers.RoomManager;
import me.dennis.exitfinder.types.GameObject;

public class Wall extends GameObject {

	RoomManager rm = Game.roommanager;
	
	public Wall(Integer x, Integer y) {
		super(x, y);
		width = 50;
		height = 50;
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
		for (GameObject object : rm.getObjects()) {
			if (object instanceof Wall) {
				
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(0x0));
		g.fillRect((int) x, (int) y, width, height);
	}

}
