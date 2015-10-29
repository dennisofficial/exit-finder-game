package me.dennis.exitfinder.rooms;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import me.dennis.exitfinder.core.Camera;
import me.dennis.exitfinder.enums.RoomEnum;
import me.dennis.exitfinder.input.Keyboard;
import me.dennis.exitfinder.managers.RoomManager;
import me.dennis.exitfinder.types.Room;
import me.dennis.exitfinder.utils.KeyMap;
import me.dennis.exitfinder.utils.Settings;

public class RoomPause extends Room {

	private float cx, cy;
	
	public BufferedImage image;
	public BufferedImage blurImage;
	
	@Override
	public void init() {
	}

	@Override
	public void update() {
		if (Keyboard.isPressed(KeyMap.menuPause())) {
			RoomManager.setRoom(RoomEnum.LEVEL);
			Camera.x = cx;
			Camera.y = cy;
		}
	}

	@Override
	public void beginDraw(Graphics g2d) {
		if (blurImage == null) {
			blurImage = blurImage();
		}
		g2d.drawImage(blurImage, 0, 0, null);
	}

	@Override
	public void endDraw(Graphics g) {
	}
	
	public void setVariables(float cx, float cy, Room room) {
		this.cx = cx;
		this.cy = cy;
	}

	public BufferedImage blurImage() {
		BufferedImage output = new BufferedImage(Settings.width, Settings.height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				int r=0,g=0,b=0,d=0;
				for (int i = x-1; i <= x+1; i++) {
					for (int j = y-1; j <= y+1; j++) {
						try {
							Pixel p = getPixel(i, j);
							r += p.r;
							g += p.g;
							b += p.b;
							d++;
						} catch(IndexOutOfBoundsException e) {}
					}
				}
				r /= d;
				g /= d;
				b /= d;
				int[] rgb = {r, g, b};
				output.getRaster().setPixels(x, y, 1, 1, rgb);
			}
		}
		return output;
	}
	
	public Pixel getPixel(int x, int y) {
		int r,g,b;
		int[] ar = image.getRaster().getPixel(x, y, new int[3]);
		r = ar[0];
		g = ar[1];
		b = ar[2];
		return new Pixel(r, g, b);
	}
	
}
class Pixel {
	
	int r,g,b;
	
	public Pixel(int red, int green, int blue) {
		r = red;
		g = green;
		b = blue;
	}
	
}
