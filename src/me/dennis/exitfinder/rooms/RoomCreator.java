package me.dennis.exitfinder.rooms;

import com.sun.glass.events.KeyEvent;

import me.dennis.exitfinder.core.Camera;
import me.dennis.exitfinder.core.Game;
import me.dennis.exitfinder.input.Keyboard;
import me.dennis.exitfinder.objects.Creator;
import me.dennis.exitfinder.objects.Wall;
import me.dennis.exitfinder.types.GameObject;
import me.dennis.exitfinder.types.Room;

public class RoomCreator extends Room {

	Keyboard key = Game.keyboard;
	
	Creator c = new Creator(0, 0);
	
	@Override
	public void init() {
		objects.add(c);
	}

	@Override
	public void update() {
		Camera.dx = (int) c.x;
		Camera.dy = (int) c.y;
		if (key.isPressed(KeyEvent.VK_UP)) {
			c.y -= c.height;
		}
		if (key.isPressed(KeyEvent.VK_DOWN)) {
			c.y += c.height;
		}
		if (key.isPressed(KeyEvent.VK_LEFT)) {
			c.x -= c.width;
		}
		if (key.isPressed(KeyEvent.VK_RIGHT)) {
			c.x += c.width;
		}
		if (key.isPressed(KeyEvent.VK_SPACE)) {
			for (GameObject object : objects) {
				if (!(object instanceof Creator)) {
					if (object.bounds.equals(c.bounds)) {
						return;
					}
				}
			}
			objects.add(new Wall((int) c.x, (int) c.y));
		}
		if (key.isPressed(KeyEvent.VK_ENTER)) {
			for (GameObject object : objects) {
				if (!(object instanceof Creator)) {
					System.out.print(object.getClass().getSimpleName() + "," + (int) object.x + "," + (int) object.y + ";");
				}
			}
		}
	}

}
