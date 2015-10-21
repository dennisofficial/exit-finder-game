package me.dennis.exitfinder.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import me.dennis.exitfinder.core.Game;
import me.dennis.exitfinder.managers.RoomManager;
import me.dennis.exitfinder.types.GameObject;

public class Wall extends GameObject {

	RoomManager rm = Game.roommanager;
	
	public BufferedImage image = null;
	
	public Wall(Integer x, Integer y, Integer meta) {
		super(x, y, meta);
		width = 32;
		height = 32;
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
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
enum Block {
	
	GRASS;

	public Integer getId() {
		return this.ordinal();
	}
	
}