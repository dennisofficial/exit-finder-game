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

	private double hozGain = 0.5;
	private double hozMax = 3;

	public Player(Integer x, Integer y) {
		super(x, y);
		width = 50;
		height = 50;
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
		gravity();
		movementHoz();
		jump();
		collision();
	}

	private void gravity() {
		vspeed += 0.25;
	}

	public void movementHoz() {
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
		}
	}
	
	public void collision() {
		for (GameObject object : rm.getObjects()) {
			if (object instanceof Wall) {
				Wall wall = (Wall) object;
				if (vspeed > 0) {
					Point L = new Point((int) (x + 1), (int) (y + height + vspeed - 1));
					Point R = new Point((int) (x + width - 1), (int) (y + height + vspeed - 1));
					if (wall.bounds.contains(L) || wall.bounds.contains(R)) {
						vspeed = 0;
						break;
					}
				}
				if (vspeed < 0) {
					Point L = new Point((int) x, (int) (y + vspeed));
					Point R = new Point((int) x + height - 1, (int) (y + vspeed));
					if (wall.bounds.contains(L) || wall.bounds.contains(R)) {
						vspeed = 0;
						break;
					}
				}
			}
		}
		for (GameObject object : rm.getObjects()) {
			if (object instanceof Wall) {
				Wall wall = (Wall) object;
				if (hspeed > 0) {
					Point T = new Point((int) (x + width + hspeed - 1), (int) y);
					Point B = new Point((int) (x + width + hspeed - 1), (int) y + height - 1);
					if (wall.bounds.contains(T) || wall.bounds.contains(B)) {
						hspeed = 0;
						break;
					}
				}
				if (hspeed < 0) {
					Point T = new Point((int) (x + hspeed), (int) y);
					Point B = new Point((int) (x + hspeed), (int) y + height - 1);
					if (wall.bounds.contains(T) || wall.bounds.contains(B)) {
						hspeed = 0;
						break;
					}
				}
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(0xDAA1A1));
		g.fillRect((int) x, (int) y, width, height);
	}

}
