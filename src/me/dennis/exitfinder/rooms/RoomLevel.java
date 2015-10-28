package me.dennis.exitfinder.rooms;

import java.awt.Graphics;

import me.dennis.exitfinder.enums.Level;
import me.dennis.exitfinder.managers.CloudManager;
import me.dennis.exitfinder.types.Background;
import me.dennis.exitfinder.types.Room;
import me.dennis.exitfinder.utils.MapLoader;

public class RoomLevel extends Room {

	Background bg = new Background(0xACD7FF);
	CloudManager cm = new CloudManager();
	
	@Override
	public void init() {
		objects.addAll(MapLoader.loadLevel(Level.W0L1));
	}

	@Override
	public void update() {
		cm.update();
	}

	@Override
	public void beginDraw(Graphics g) {
		bg.draw(g);
		cm.draw(g);
	}

	@Override
	public void endDraw(Graphics g) {
	}

}
