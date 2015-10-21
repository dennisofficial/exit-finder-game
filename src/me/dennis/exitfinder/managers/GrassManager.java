package me.dennis.exitfinder.managers;

import java.awt.Point;

import me.dennis.exitfinder.core.Game;
import me.dennis.exitfinder.enums.Image;
import me.dennis.exitfinder.objects.Wall;
import me.dennis.exitfinder.types.GameObject;

public class GrassManager {

	RoomManager rm = Game.roommanager;

	int lastSize = 0;

	public void check() {
		if (rm.getObjects().size() != lastSize) {
			lastSize = rm.getObjects().size();
			update();
		}
	}

	public void update() {
		for (GameObject object : rm.getObjects()) {
			if (object instanceof Wall) {
				Wall wall = (Wall) object;
				if (wall.metadata == 0) {
					updateImage(wall);
				}
			}
		}
	}

	private void updateImage(Wall obj) {
		for (GameObject object : rm.getObjects()) {
			if (object instanceof Wall) {
				Wall wall = (Wall) object;
				Point p = new Point((int) obj.x + obj.width / 2 - 1, (int) obj.y - obj.height / 2 - 1);
				if (wall.bounds.contains(p)) {
					obj.image = Image.DIRT.getImage();
					return;
				}
			}
		}
		obj.image = Image.GRASS.getImage();
	}

}
