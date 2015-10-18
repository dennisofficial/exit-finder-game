package me.dennis.exitfinder.rooms;

import me.dennis.exitfinder.core.Game;
import me.dennis.exitfinder.enums.Level;
import me.dennis.exitfinder.types.Room;
import me.dennis.exitfinder.utils.MapLoader;

public class RoomMain extends Room {

	MapLoader ml = Game.maploader;
	
	@Override
	public void init() {
		objects.addAll(ml.loadLevel(Level.W0L1));
	}

	@Override
	public void update() {
	}

}
