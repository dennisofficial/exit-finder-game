package me.dennis.exitfinder.objects;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import me.dennis.exitfinder.enums.Image;
import me.dennis.exitfinder.managers.RoomManager;
import me.dennis.exitfinder.types.GameObject;

public class Elevator extends GameObject {

	Direction TO = Direction.TO;
	Direction BACK = Direction.BACK;
	
	BufferedImage image = Image.GRASS_SLAB.getImage();
	
	int top, bot;
	int speed = 3;
	Direction dir = TO;
	
	public Elevator(Integer x, Integer y, Integer meta) {
		super(x, y, meta);
		width = 32;
		height = 16;
		top = y - 128;
		bot = y;
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
		if (dir.equals(TO)) {
			if (y > top) {
				y -= speed;
			}
			else {
				dir = BACK;
			}
		}
		if (dir.equals(BACK)) {
			if (y < bot) {
				y += speed;
			}
			else {
				dir = TO;
			}
		}
		collisionCheck();
	}
	
	private void collisionCheck() {
		for (GameObject object : RoomManager.getObjects()) {
			if (object instanceof Player) {
				Player player = (Player) object;
				Point TL = new Point((int) x, (int) y - speed - 1);
				Point TR = new Point((int) x + width - 1, (int) y - speed - 1);
				if (player.bounds.contains(TL) || player.bounds.contains(TR)) {
					player.y = y - player.height;
					break;
				}
				Point BL = new Point((int) x, (int) y + height + speed);
				Point BR = new Point((int) x + width - 1, (int) y + height + speed);
				if (player.bounds.contains(BL) || player.bounds.contains(BR)) {
					player.vspeed = speed + 1;
					break;
				}
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(image, (int) x, (int) y, width, height, null);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
	
}

enum Direction { TO, BACK }