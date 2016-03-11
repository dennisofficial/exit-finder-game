package me.dennis.exitfinder.types;

import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;

import me.dennis.exitfinder.managers.CloudManager;

public class Cloud {

	private CloudManager cm;
	private Integer x;
	private Integer y;
	private Integer h;
	private Integer w;
	private Integer d;
	private Integer shade = new SecureRandom().nextInt(80) + 175;
	private Color color = new Color(shade, shade, shade);
	
	public Cloud(Integer x, Integer y, CloudManager cm) {
		this.x = x;
		this.y = y;
		this.cm = cm;
		h = 20;
		d = w = (h / 2) * 3;
	}
	
	public void update() {
		//g.fillRect((int) -Camera.x, (int) -Camera.y, Settings.width, Settings.height);
		if (x > -w * 2) {
			x--;
		}
		else {
			cm.destroy(this);
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, d * 2, d * 2);
		g.fillOval(x - d, y + h, (d / 3) * 4, (d / 3) * 4);
		g.fillOval(x, y + (h / 2) * 3, (d / 3) * 4, (d / 3) * 4);
		g.fillOval(x + d, y + h, (d / 3) * 4, (d / 3) * 4);
	}
	
}
