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
	private Room room;

	public BufferedImage image;
	public BufferedImage blurImage;

	@Override
	public void init() {
	}

	@Override
	public void update() {
		if (blurImage == null) {
			blurImage = blurImage();
			image = blurImage;
		}
		if (Keyboard.isPressed(KeyMap.menuPause())) {
			RoomManager.setRoom(RoomEnum.getEnum(room));
			Camera.x = cx;
			Camera.y = cy;
			blurImage = null;
		}
	}

	@Override
	public void beginDraw(Graphics g2d) {
		if (blurImage == null) {
			g2d.drawImage(image, 0, 0, null);
		}
		else {
			g2d.drawImage(blurImage, 0, 0, Settings.width, Settings.height, null);
		}
	}

	@Override
	public void endDraw(Graphics g) {
	}

	public void setVariables(float cx, float cy, Room room) {
		this.cx = cx;
		this.cy = cy;
		this.room = room;
	}

	public BufferedImage blurImage() {
		BufferedImage output = new BufferedImage(Settings.width/2, Settings.height/2, BufferedImage.TYPE_INT_RGB);
		// Kernel Size
		int size = 2;
		// Image processing algorithm
		for (int x = 0; x < image.getWidth(); x+=2) {
			for (int y = 0; y < image.getHeight(); y+=2) {
				int r = 0, g = 0, b = 0, d = 0;
				for (int i = x - size; i <= x + size; i++) {
					for (int j = y - size; j <= y + size; j++) {
						try {
							int[] p = image.getRaster().getPixel(i, j, new int[3]);
							r += p[0];
							g += p[1];
							b += p[2];
							d++;
						} catch (IndexOutOfBoundsException e) {}
					}
				}
				r /= d;
				g /= d;
				b /= d;
				int[] rgb = { r, g, b };
				output.getRaster().setPixels(x/2, y/2, 1, 1, rgb);
			}
		}
		return output;
	}

}
