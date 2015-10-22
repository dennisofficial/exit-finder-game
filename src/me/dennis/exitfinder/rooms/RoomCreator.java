package me.dennis.exitfinder.rooms;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import me.dennis.exitfinder.core.Camera;
import me.dennis.exitfinder.core.Game;
import me.dennis.exitfinder.input.Keyboard;
import me.dennis.exitfinder.input.Mouse;
import me.dennis.exitfinder.managers.RoomManager;
import me.dennis.exitfinder.objects.Creator;
import me.dennis.exitfinder.objects.Wall;
import me.dennis.exitfinder.types.GameObject;
import me.dennis.exitfinder.types.Room;
import me.dennis.exitfinder.utils.Settings;

public class RoomCreator extends Room {

	RoomManager rm = Game.roommanager;
	Settings s = Game.settings;
	Keyboard key = Game.keyboard;
	Mouse mouse = Game.mouse;

	Creator c = new Creator(0, 0, 0);
	Rectangle viewport = new Rectangle(0, 0, s.width, s.height);
	Point add = new Point(0, 0);
	Point remove = new Point(0, 0);
	
	boolean b = false;
	
	@Override
	public void init() {
	}

	@Override
	public void update() {
		viewport.x = (int) -Camera.x;
		viewport.y = (int) -Camera.y;
		mouse();
		keyboard();
	}

	public void mouse() {
		Point p = (Point) mouse.getPoint().clone();
		c.x = (int) (p.x / 32) * 32 - s.width / 2 + Camera.dx;
		c.y = (int) (p.y / 32) * 32 - s.height / 2 + Camera.dy;
		if (mouse.isPressed(MouseEvent.BUTTON1)) {
			add.setLocation(c.x, c.y);
		}
		if (mouse.isPressed(MouseEvent.BUTTON3)) {
			remove.setLocation(c.x, c.y);
		}
		if (mouse.isReleased(MouseEvent.BUTTON1)) {
			if (add.equals(new Point((int) c.x, (int) c.y))) {
				boolean create = true;
				for (GameObject object : rm.getObjects()) {
					if (object.bounds.contains(c.x, c.y)) {
						create = false;
						break;
					}
				}
				if (create) {
					rm.getObjects().add(new Wall((int) c.x, (int) c.y, 0));
				}
			}
		}
		if (mouse.isReleased(MouseEvent.BUTTON3)) {
			if (remove.equals(new Point((int) c.x, (int) c.y))) {
				GameObject delete = null;
				for (GameObject object : rm.getObjects()) {
					if (object.bounds.contains(c.x, c.y)) {
						delete = object;
						break;
					}
				}
				if (delete != null) {
					rm.getObjects().remove(delete);
				}
			}
		}
	}

	public void keyboard() {
		if (key.isPressed(KeyEvent.VK_UP)) {
			Camera.dy -= c.height;
			Camera.y += c.height;
		}
		if (key.isPressed(KeyEvent.VK_DOWN)) {
			Camera.dy += c.height;
			Camera.y -= c.height;
		}
		if (key.isPressed(KeyEvent.VK_LEFT)) {
			Camera.dx -= c.width;
			Camera.x += c.width;
		}
		if (key.isPressed(KeyEvent.VK_RIGHT)) {
			Camera.dx += c.width;
			Camera.x -= c.width;
		}
		if (key.isPressed(KeyEvent.VK_ENTER)) {
			for (GameObject object : objects) {
				if (!(object instanceof Creator)) {
					System.out.print(object.getClass().getSimpleName() + "," + (int) object.x + "," + (int) object.y + ",0;");
				}
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		c.draw(g);
	}

}
