package me.dennis.exitfinder.enums;

public enum RoomEnum {

	MAIN,
	CREATOR;
	
	public Integer getId() {
		return this.ordinal();
	}
	
}
