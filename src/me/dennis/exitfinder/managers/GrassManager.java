package me.dennis.exitfinder.managers;

import java.awt.Point;

import me.dennis.exitfinder.enums.Image;
import me.dennis.exitfinder.objects.Wall;
import me.dennis.exitfinder.types.GameObject;

public class GrassManager {

	int lastSize = 0;

	public void check() {
		if (RoomManager.getObjects().size() != lastSize) {
			lastSize = RoomManager.getObjects().size();
			update();
		}
	}

	public void update() {
		for (GameObject object : RoomManager.getObjects()) {
			if (object instanceof Wall) {
				Wall wall = (Wall) object;
				if (wall.metadata == 0) {
					updateImage(wall);
				}
			}
		}
	}

	private void updateImage(Wall obj) {
		for (GameObject object : RoomManager.getObjects()) {
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
