package me.dennis.exitfinder.objects;

import java.awt.Color;
import java.awt.Graphics;

import me.dennis.exitfinder.core.Camera;
import me.dennis.exitfinder.core.Game;
import me.dennis.exitfinder.enums.Image;
import me.dennis.exitfinder.input.Keyboard;
import me.dennis.exitfinder.managers.RoomManager;
import me.dennis.exitfinder.types.GameObject;
import me.dennis.exitfinder.utils.Settings;

public class Creator extends GameObject {

	RoomManager rm = Game.roommanager;
	Keyboard key = Game.keyboard;
	Settings s = Game.settings;
	
	public Creator(Integer x, Integer y, Integer meta) {
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
		g.drawImage(Image.CURSOR.getImage(), (int) x, (int) y, width, height, null);
		g.setColor(new Color(0x0));
		g.drawString("X: " + x +
				" - Y: " + y +
				" - Objects: " + (rm.getObjects().size() - 1), 
				(int) -Camera.x + 10, (int) -Camera.y + s.height - 40);
	}

}
