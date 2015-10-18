package me.dennis.exitfinder.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import me.dennis.exitfinder.core.Game;
import me.dennis.exitfinder.enums.Image;
import me.dennis.exitfinder.managers.RoomManager;
import me.dennis.exitfinder.types.GameObject;

public class Wall extends GameObject {

	RoomManager rm = Game.roommanager;
	BufferedImage image = null;
	
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
				Wall wall = (Wall) object;
				Point p = new Point((int) x + width/2 - 1, (int) y - height/2 - 1);
				if (wall.bounds.contains(p)) {
					image = Image.DIRT.getImage();
					return;
				}
			}
		}
		image = Image.GRASS.getImage();
	}

	@Override
	public void draw(Graphics g) {
		//g.drawImage(image, (int) x, (int) y, width, height, null);
		g.setColor(new Color(0x0));
		g.fillRect((int) x, (int) y, width, height);
	}

}
