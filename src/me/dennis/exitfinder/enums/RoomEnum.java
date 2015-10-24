package me.dennis.exitfinder.enums;

import me.dennis.exitfinder.types.Room;

public enum RoomEnum {

	LEVEL,
	CREATOR,
	PAUSE;
	
	public Integer getId() {
		return this.ordinal();
	}
	
	public Room getRoom() {
		return null;
	}
	
}
