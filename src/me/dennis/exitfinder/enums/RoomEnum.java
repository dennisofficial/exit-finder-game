package me.dennis.exitfinder.enums;

import me.dennis.exitfinder.rooms.*;
import me.dennis.exitfinder.types.Room;

public enum RoomEnum {

	LEVEL(new RoomLevel()),
	CREATOR(new RoomCreator()),
	PAUSE(new RoomPause());
	
	public Room room;
	
	private RoomEnum(Room room) {
		this.room = room;
	}
	
}
