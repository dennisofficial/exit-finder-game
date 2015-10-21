package me.dennis.exitfinder.core;

import java.awt.Point;

import me.dennis.exitfinder.managers.RoomManager;
import me.dennis.exitfinder.objects.Player;
import me.dennis.exitfinder.types.GameObject;
import me.dennis.exitfinder.utils.Settings;

public class Camera {

	public static float x;
	public static float y;
	public static int dx;
	public static int dy;
	
	Settings s = Game.settings;
	RoomManager rm = Game.roommanager;
	
	public Camera() {
		Point p = getPoint();
		x = -p.x + s.width/2;
		y = -p.x + s.height/2;
	}
	
	public void update() {
		Point p = getPoint();
		try {
			x += (-p.x + s.width/2 - x) * 0.015f;
			y += (-p.y + s.height/2 - y) * 0.05f;
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
