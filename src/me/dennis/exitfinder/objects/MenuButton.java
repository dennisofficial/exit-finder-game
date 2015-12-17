package me.dennis.exitfinder.objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import me.dennis.exitfinder.input.Mouse;
import me.dennis.exitfinder.types.GameObject;

public class MenuButton extends GameObject {

	public String text = "";
	public Color bgcolor, bgcolorH, txtcolor, txtcolorH;

	public MenuButton(Integer x, Integer y, Integer meta) {
		super(x, y, meta);
		width = 0;
		height = 0;
	}
	
	public MenuButton initialize(String text, int bgcolor, int bgcolorH, int txtcolor, int txtcolorH) {
		this.text = text;
		this.bgcolor = new Color(bgcolor);
		this.bgcolorH = new Color(bgcolorH);
		this.txtcolor = new Color(txtcolor);
		this.txtcolorH = new Color(txtcolorH);
		return this;
	}
	
	@Override
	public void init() {
	}

	/* FINISH BUTTON DYNAMIC STRING WIDTH/HEIGHT */
	
	@Override
	public void update() {
	}

	@Override
	public void draw(Graphics g) {
		Font font = g.getFont();
		if (bounds.contains(Mouse.getPoint())) {
			g.setColor(bgcolorH);
			g.fillRect((int) x, (int) y, width, height);
			g.setColor(txtcolorH);
			g.drawString(text, (int) x + (width/2), (int) y + (height + font.getSize()) / 2);
		}
		else {
			g.setColor(bgcolor);
			g.fillRect((int) x, (int) y, width, height);
			g.setColor(txtcolor);
			g.drawString(text, (int) x + (width/2), (int) y + (height + font.getSize()) / 2);
		}
	}

}
