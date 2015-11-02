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
	Direction LEFT = Direction.LEFT;
	Direction RIGHT = Direction.RIGHT;

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
				if (hspeed > 0)
					hspeed -= hozGain;
				if (hspeed < 0)
					hspeed += hozGain;
			} else {
				// L
				if (hspeed > -hozMax)
					hspeed -= hozGain;
			}
		} else {
			if (Keyboard.isDirect(KeyMap.playerRight())) {
				// R
				if (hspeed < hozMax)
					hspeed += hozGain;
			} else {
				// NONE
				if (hspeed > 0)
					hspeed -= hozGain;
				if (hspeed < 0)
					hspeed += hozGain;
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
						generateRunningParticles();
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
								generateRunningParticles();
							}
						}
						x = object.x - width;
						for (int i = 0; i < 5; i++) {
							generateWallParticles(RIGHT);
						}
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
								generateRunningParticles();
							}
						}
						x = object.x + object.width;
						for (int i = 0; i < 5; i++) {
							generateWallParticles(LEFT);
						}
						hspeed = 0;
					}
				}
			}
		}
	}

	private void generateRunningParticles() {
		int a = (255 / 3) * 2;
		a *= Math.abs(hspeed) / hozMax;
		SecureRandom sr = new SecureRandom();
		int x = (int) this.x;
		int y = (int) this.y + height - 1;
		int ox = sr.nextInt(width);
		int oy = 0;
		int dx = (int) -hspeed / 2;
		int dy = -sr.nextInt(2);
		pm.parts.add(new Particle(x, y, ox, oy, dx, dy, 0xFF, 0xFF, 0xFF, a));
	}

	private void generateWallParticles(Direction dir) {
		int a = 255;
		a *= Math.abs(hspeed) / hozMax;
		SecureRandom sr = new SecureRandom();
		int x = (int) this.x + width / 2;
		if (dir.equals(LEFT)) {
			x -= width / 2;
		} else {
			x += width / 2;
		}
		int y = (int) this.y;
		int ox = sr.nextInt(10);
		if (dir.equals(LEFT)) {
			ox *= -1;
		}
		int oy = sr.nextInt(height);
		int dx = (int) -hspeed / 3;
		int dy = sr.nextInt(4) - 2;
		pm.parts.add(new Particle(x, y, ox, oy, dx, dy, 0xFF, 0xFF, 0xFF, a));
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

	enum Direction {
		LEFT, RIGHT
	}
}