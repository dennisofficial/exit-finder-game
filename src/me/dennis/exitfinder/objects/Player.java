package me.dennis.exitfinder.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.security.SecureRandom;

import me.dennis.exitfinder.input.Keyboard;
import me.dennis.exitfinder.managers.ParticleManager;
import me.dennis.exitfinder.managers.RoomManager;
import me.dennis.exitfinder.types.GameObject;
import me.dennis.exitfinder.types.Particle;
import me.dennis.exitfinder.utils.KeyMap;

public class Player extends GameObject {

	ParticleManager pm = new ParticleManager();
	
	double hozGain = 0.5;
	double hozMax = 3;

	public Player(Integer x, Integer y, Integer meta) {
		super(x, y, meta);
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
		pm.update();
	}

	private void movementHoz() {
		if (Keyboard.isDirect(KeyMap.playerLeft())) {
			if (Keyboard.isDirect(KeyMap.playerRight())) {
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
			if (Keyboard.isDirect(KeyMap.playerRight())) {
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
		if (Keyboard.isPressed(KeyMap.playerJump())) {
			for (GameObject object : RoomManager.getObjects()) {
				if (object.isSolid() && !object.equals(this)) {
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
		for (GameObject object : RoomManager.getObjects()) {
			if (object.isSolid() && !object.equals(this)) {
				if (vspeed > 0) {
					Point L = new Point((int) (x + 1), (int) (y + height + vspeed - 1));
					Point R = new Point((int) (x + width - 1), (int) (y + height + vspeed - 1));
					if (object.bounds.contains(L) || object.bounds.contains(R)) {
						y = object.y - height;
						vspeed = 0;
						generateParticles();
					}
				}
				if (vspeed < 0) {
					Point L = new Point((int) x, (int) (y + vspeed));
					Point R = new Point((int) x + height - 1, (int) (y + vspeed));
					if (object.bounds.contains(L) || object.bounds.contains(R)) {
						y = object.y + object.height;
						vspeed = 0;
					}
				}
				if (hspeed > 0) {
					Point T = new Point((int) (x + width + hspeed - 1), (int) y);
					Point B = new Point((int) (x + width + hspeed - 1), (int) y + height - 1);
					if (object.bounds.contains(T) || object.bounds.contains(B)) {
						if (object instanceof Wood) {
							Wood wood = (Wood) object;
							if (!wood.check(1)) {
								object.x = x + width + 1;
								generateParticles();
							}
						}
						x = object.x - width;
						hspeed = 0;
					}
				}
				if (hspeed < 0) {
					Point T = new Point((int) (x + hspeed), (int) y);
					Point B = new Point((int) (x + hspeed), (int) y + height - 1);
					if (object.bounds.contains(T) || object.bounds.contains(B)) {
						if (object instanceof Wood) {
							Wood wood = (Wood) object;
							if (!wood.check(-1)) {
								object.x = x - width - 1;
								generateParticles();
							}
						}
						x = object.x + object.width;
						hspeed = 0;
					}
				}
			}
		}
	}

	private void generateParticles() {
		// particle generator
		int a = 255;
		a *= Math.abs(hspeed)/hozMax;
		SecureRandom sr = new SecureRandom();
		pm.parts.add(new Particle(
				(int) x + width/2, // x
				(int) y + height - 1, // y
				sr.nextInt(width) - width/2, 0, // offset
				(int) -hspeed/2, -sr.nextInt(2), // delta
				0xFF, 0xFF, 0xFF, a));
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(0xB0B0B0));
		g.fillRect((int) x, (int) y, width, height);
		pm.draw(g);
	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
