package me.dennis.exitfinder.enums;

public enum RoomEnum {

	LEVEL,
	CREATOR,
	PAUSE;
	
	public Integer getId() {
		return this.ordinal();
	}
	
}
