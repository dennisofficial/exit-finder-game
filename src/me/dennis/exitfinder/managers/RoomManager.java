package me.dennis.exitfinder.managers;

import java.awt.Graphics;
import java.util.List;

import me.dennis.exitfinder.enums.RoomEnum;
import me.dennis.exitfinder.types.GameObject;
import me.dennis.exitfinder.types.Room;

public class RoomManager {

	static Room room = RoomEnum.LEVEL.room;
	
	public static void setRoom(RoomEnum room) {
		RoomManager.room = room.room;
	}

	public static List<GameObject> getObjects() {
		return room.objects;
	}
	
	public static void init() {
		room.init();
		for (GameObject object : room.objects) {
			object.init();
		}
	}
	
	public static void update() {
		room.update();
		for (GameObject object : room.objects) {
			object.update();
			object.velocity();
		}
	}
	
	public static void draw(Graphics g) {
		room.draw(g);
		for (GameObject object : room.objects) {
			object.draw(g);
		}
	}
	
}
