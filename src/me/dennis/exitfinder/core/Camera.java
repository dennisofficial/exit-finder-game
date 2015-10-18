package me.dennis.exitfinder.core;

import me.dennis.exitfinder.managers.RoomManager;
import me.dennis.exitfinder.objects.Player;
import me.dennis.exitfinder.types.GameObject;
import me.dennis.exitfinder.utils.Settings;

public class Camera {

	public float x;
	public float y;
	
	Settings s = Game.settings;
	RoomManager rm = Game.roommanager;
	
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void update() {
		Player player = getPlayer();
		x += (int) (-player.x + s.WIDTH/2 - x - player.width) * 0.02f;
		y += (int) (-player.y + s.HEIGHT/2 - y - player.height) * 0.12f;
	}
	
	public Player getPlayer() {
		for (GameObject object : rm.getObjects()) {
			if (object instanceof Player) {
				return (Player) object;
			}
		}
		return null;
	}
	
}
