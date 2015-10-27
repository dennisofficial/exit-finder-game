package me.dennis.exitfinder.types;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public abstract class Room {

	public List<GameObject> objects = new ArrayList<GameObject>();
	
	public abstract void init();
	public abstract void update();
	public abstract void beginDraw(Graphics g);
	public abstract void endDraw(Graphics g);

	
}
