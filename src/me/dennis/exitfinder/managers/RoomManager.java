package me.dennis.exitfinder.managers;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import me.dennis.exitfinder.enums.RoomEnum;
import me.dennis.exitfinder.rooms.RoomCreator;
import me.dennis.exitfinder.rooms.RoomMain;
import me.dennis.exitfinder.types.GameObject;
import me.dennis.exitfinder.types.Room;

public class RoomManager {

	public List<Room> rooms = new ArrayList<Room>();
	public Integer cr = RoomEnum.MAIN.getId();
	
	public void setupRooms() {
		rooms.add(new RoomMain());
		rooms.add(new RoomCreator());
		init();
	}
	
	public void setRoom(RoomEnum room) {
		cr = room.getId();
	}

	public List<GameObject> getObjects() {
		return rooms.get(cr).objects;
	}
	
	public void init() {
		rooms.get(cr).init();
		for (GameObject object : rooms.get(cr).objects) {
			object.init();
		}
	}
	
	public void update() {
		rooms.get(cr).update();
		for (GameObject object : rooms.get(cr).objects) {
			object.update();
			object.velocity();
		}
	}
	
	public void draw(Graphics g) {
		rooms.get(cr).draw(g);
		for (GameObject object : rooms.get(cr).objects) {
			object.draw(g);
		}
	}
	
}
