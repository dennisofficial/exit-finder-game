package me.dennis.exitfinder.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import me.dennis.exitfinder.core.Game;
import me.dennis.exitfinder.input.Keyboard;
import me.dennis.exitfinder.managers.RoomManager;
import me.dennis.exitfinder.types.GameObject;
import me.dennis.exitfinder.utils.KeyMap;

public class Player extends GameObject {

	RoomManager rm = Game.roommanager;
	Keyboard key = Game.keyboard;
	KeyMap km = Game.keymap;

	double hozGain = 0.5;
	double hozMax = 3;

	public Player(Integer x, Integer y) {
		super(x, y);
		width = 32;
		height = 32;
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
		movementHoz();
		vspeed += 0.5;
		jump();
		collision();
	}

	private void movementHoz() {
		if (key.isDirect(km.playerLeft())) {
			if (key.isDirect(km.playerRight())) {
				// L + R
				if (hspeed > 0) hspeed -= hozGain;
				if (hspeed < 0) hspeed += hozGain;
			}
			else {
				// L
				if (hspeed > -hozMax) hspeed -= hozGain;
			}
		}
		else {
			if (key.isDirect(km.playerRight())) {
				// R
				if (hspeed < hozMax) hspeed += hozGain;

			}
			else {
				// NONE
				if (hspeed > 0) hspeed -= hozGain;
				if (hspeed < 0) hspeed += hozGain;
			}
		}
	}

	public void jump() {
		if (key.isPressed(km.playerJump())) {
			for (GameObject object : rm.getObjects()) {
				if (object.isSolid()) {
					Point L = new Point((int) x, (int) (y + height + vspeed));
					Point R = new Point((int) (x + height - 1), (int) (y + height + vspeed));
					if (object.bounds.contains(L) || object.bounds.contains(R)) {
						vspeed -= 11;
						break;
					}
				}
			}
		}
	}

	public void collision() {
		for (GameObject object : rm.getObjects()) {
			if (object.isSolid()) {
				Wall wall = (Wall) object;
				if (vspeed > 0) {
					Point L = new Point((int) (x + 1), (int) (y + height + vspeed - 1));
					Point R = new Point((int) (x + width - 1), (int) (y + height + vspeed - 1));
					if (wall.bounds.contains(L) || wall.bounds.contains(R)) {
						y = wall.y - height;
						vspeed = 0;
						break;
					}
				}
				if (vspeed < 0) {
					Point L = new Point((int) x, (int) (y + vspeed));
					Point R = new Point((int) x + height - 1, (int) (y + vspeed));
					if (wall.bounds.contains(L) || wall.bounds.contains(R)) {
						y = wall.y + wall.height;
						vspeed = 0;
						break;
					}
				}
			}
		}
		for (GameObject object : rm.getObjects()) {
			if (object.isSolid()) {
				if (hspeed > 0) {
					Point T = new Point((int) (x + width + hspeed - 1), (int) y);
					Point B = new Point((int) (x + width + hspeed - 1), (int) y + height - 1);
					if (object.bounds.contains(T) || object.bounds.contains(B)) {
						x = object.x - width;
						hspeed = 0;
						break;
					}
				}
				if (hspeed < 0) {
					Point T = new Point((int) (x + hspeed), (int) y);
					Point B = new Point((int) (x + hspeed), (int) y + height - 1);
					if (object.bounds.contains(T) || object.bounds.contains(B)) {
						x = object.x + object.width;
						hspeed = 0;
						break;
					}
				}
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(0xFFFFFF));
		g.fillRect((int) x, (int) y, width, height);
	}

}
