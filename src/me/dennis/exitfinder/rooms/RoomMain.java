package me.dennis.exitfinder.rooms;

import me.dennis.exitfinder.enums.RoomEnum;
import me.dennis.exitfinder.objects.Player;
import me.dennis.exitfinder.types.Room;

public class RoomMain extends Room {

	public RoomMain(RoomEnum room) {
		super(room);
		objects.add(new Player(0, 0));
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
	}

}
