package me.dennis.exitfinder.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import me.dennis.exitfinder.core.Game;
import me.dennis.exitfinder.managers.RoomManager;
import me.dennis.exitfinder.types.GameObject;

public class Wood extends GameObject {

	RoomManager rm = Game.roommanager;

	public Wood(Integer x, Integer y, Integer meta) {
		super(x, y, meta);
		width = 32;
		height = 32;
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
		vspeed += 0.5;
		if (hspeed > 0) hspeed -= 0.5;
		if (hspeed < 0) hspeed += 0.5;
		collision();
	}

	public void collision() {
		for (GameObject object : rm.getObjects()) {
			if (object.isSolid() && !(object instanceof Wood)) {
				if (vspeed > 0) {
					Point L = new Point((int) (x + 1), (int) (y + height + vspeed - 1));
					Point R = new Point((int) (x + width - 1), (int) (y + height + vspeed - 1));
					if (object.bounds.contains(L) || object.bounds.contains(R)) {
						y = object.y - height;
						vspeed = 0;
					}
				}
				if (vspeed < 0) {
					Point L = new Point((int) x, (int) (y + vspeed));
					Point R = new Point((int) x + height - 1, (int) (y + vspeed));
					if (object.bounds.contains(L) || object.bounds.contains(R)) {
						y = object.y + object.height;
						vspeed = 0;
					}
				}
				if (hspeed > 0) {
					Point T = new Point((int) (x + width + hspeed - 1), (int) y);
					Point B = new Point((int) (x + width + hspeed - 1), (int) y + height - 1);
					if (object.bounds.contains(T) || object.bounds.contains(B)) {
						x = object.x - width;
						hspeed = 0;
					}
				}
				if (hspeed < 0) {
					Point T = new Point((int) (x + hspeed), (int) y);
					Point B = new Point((int) (x + hspeed), (int) y + height - 1);
					if (object.bounds.contains(T) || object.bounds.contains(B)) {
						x = object.x + object.width;
						hspeed = 0;
					}
				}
			}
		}
	}
	
	public boolean check(Integer i) {
		for (GameObject object : rm.getObjects()) {
			if (i > 0) {
				Point T = new Point((int) (x + width + hspeed - 1), (int) y);
				Point B = new Point((int) (x + width + hspeed - 1), (int) y + height - 1);
				if (object.bounds.contains(T) || object.bounds.contains(B)) {
					return true;
				}
			}
			if (i < 0) {
				Point T = new Point((int) (x + hspeed), (int) y);
				Point B = new Point((int) (x + hspeed), (int) y + height - 1);
				if (object.bounds.contains(T) || object.bounds.contains(B)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(0x0));
		g.fillRect((int) x, (int) y, width, height);
	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
