package me.dennis.exitfinder.managers;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import me.dennis.exitfinder.types.Particle;

public class ParticleManager {

	public List<Particle> parts = new ArrayList<Particle>();

	public void update() {
		for (int i = 0; i < parts.size(); i++) {
			Particle part = parts.get(i);
			if (!part.doRemove()) {
				part.update();
			}
			else {
				parts.remove(part);
			}
		}
	}
	
	public void draw(Graphics g) {
		for (Particle part : parts) {
			part.draw(g);
		}
	}
	
}
