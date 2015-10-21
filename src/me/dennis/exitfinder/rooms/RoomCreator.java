package me.dennis.exitfinder.rooms;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import me.dennis.exitfinder.core.Camera;
import me.dennis.exitfinder.core.Game;
import me.dennis.exitfinder.input.Keyboard;
import me.dennis.exitfinder.input.Mouse;
import me.dennis.exitfinder.objects.Creator;
import me.dennis.exitfinder.objects.Wall;
import me.dennis.exitfinder.types.GameObject;
import me.dennis.exitfinder.types.Room;
import me.dennis.exitfinder.utils.Settings;

public class RoomCreator extends Room {

	Settings s = Game.settings;
	Keyboard key = Game.keyboard;
	Mouse mouse = Game.mouse;

	Creator c = new Creator(0, 0, 0);

	Rectangle viewport = new Rectangle(0, 0, s.width, s.height);

	@Override
	public void init() {
		objects.add(c);
	}

	@Override
	public void update() {
		viewport.x = (int) -Camera.x;
		viewport.y = (int) -Camera.y;
		mouse();
	}

	public void mouse() {
		Point p = mouse.getPoint();
		int xsnap = 0;
		int ysnap = 0;
		for (int i = 0; true; i += 32) {
			if (p.x < i) {
				break;
			}
			else {
				xsnap = i;
			}
		}
		for (int i = 0; true; i += 32) {
			if (p.y < i) {
				break;
			}
			else {
				ysnap = i;
			}
		}
		c.x = xsnap - s.width/2;
		c.y = ysnap - s.height/2;
	}

	public void keyboard() {
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
			objects.add(new Wall((int) c.x, (int) c.y, 0));
		}
		if (key.isPressed(KeyEvent.VK_ENTER)) {
			for (GameObject object : objects) {
				if (!(object instanceof Creator)) {
					System.out.print(object.getClass().getSimpleName() + "," + (int) object.x + "," + (int) object.y + ";");
				}
			}
		}
	}

	@Override
	public void draw(Graphics g) {
	}

}
