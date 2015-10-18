package me.dennis.exitfinder.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import me.dennis.exitfinder.core.Camera;
import me.dennis.exitfinder.core.Game;
import me.dennis.exitfinder.enums.Image;
import me.dennis.exitfinder.managers.RoomManager;
import me.dennis.exitfinder.types.GameObject;
import me.dennis.exitfinder.utils.Settings;

public class Creator extends GameObject {

	RoomManager rm = Game.roommanager;
	Settings s = Game.settings;
	
	private List<String> labels = new ArrayList<String>();
	private int cr;
	
	public Creator(Integer x, Integer y) {
		super(x, y);
		width = 32;
		height = 32;
		
		labels.add("Wall");
		labels.add("Player");
	}

	public GameObject getObject() {
		try {
			return (GameObject) Class.forName("me.dennis.exitfinder.objects." + labels.get(cr))
			.getConstructor(Integer.class, Integer.class)
			.newInstance(x, y);
		}
		catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
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
				-Camera.x + 10, -Camera.y + s.HEIGHT - 40);
	}

}
