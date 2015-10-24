package me.dennis.exitfinder.managers;

import java.awt.Graphics;
import java.util.List;

import me.dennis.exitfinder.enums.RoomEnum;
import me.dennis.exitfinder.types.GameObject;
import me.dennis.exitfinder.types.Room;

public class RoomManager {

	Room room = RoomEnum.LEVEL.room;
	
	public void setRoom(RoomEnum room) {
		this.room = room.room;
	}

	public List<GameObject> getObjects() {
		return room.objects;
	}
	
	public void init() {
		room.init();
		for (GameObject object : room.objects) {
			object.init();
		}
	}
	
	public void update() {
		room.update();
		for (GameObject object : room.objects) {
			object.update();
			object.velocity();
		}
	}
	
	public void draw(Graphics g) {
		room.draw(g);
		for (GameObject object : room.objects) {
			object.draw(g);
		}
	}
	
}
