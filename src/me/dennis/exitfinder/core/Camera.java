package me.dennis.exitfinder.core;

import java.awt.Point;

import me.dennis.exitfinder.managers.RoomManager;
import me.dennis.exitfinder.objects.Player;
import me.dennis.exitfinder.types.GameObject;
import me.dennis.exitfinder.utils.Settings;

public class Camera {

	public static int x;
	public static int y;
	public static int dx;
	public static int dy;
	
	Settings s = Game.settings;
	RoomManager rm = Game.roommanager;
	
	public Camera() {
		Point p = getPoint();
		x = -p.x + s.WIDTH/2;
		y = -p.x + s.HEIGHT/2;
	}
	
	public void update() {
		Point p = getPoint();
		try {
			x += (int) (-p.x + s.WIDTH/2 - x) * 0.02f;
			y += (int) (-p.y + s.HEIGHT/2 - y) * 0.12f;
		} catch (NullPointerException e) {}
	}
	
	public Point getPoint() {
		for (GameObject object : rm.getObjects()) {
			if (object instanceof Player) {
				return new Point((int) object.x, (int) object.y);
			}
		}
		return new Point((int) dx, (int) dy);
	}
	
}
