package me.dennis.exitfinder.types;

import java.util.ArrayList;
import java.util.List;

import me.dennis.exitfinder.enums.RoomEnum;

public abstract class Room {

	public List<GameObject> objects = new ArrayList<GameObject>();
	private RoomEnum room;
	
	public Room(RoomEnum room) {
		this.room = room;
	}
	
	public RoomEnum getEnum() {
		return room;
	}
	
	public abstract void init();
	public abstract void update();
	
}
