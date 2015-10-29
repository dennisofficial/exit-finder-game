package me.dennis.exitfinder.rooms;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import me.dennis.exitfinder.core.Camera;
import me.dennis.exitfinder.enums.RoomEnum;
import me.dennis.exitfinder.input.Keyboard;
import me.dennis.exitfinder.managers.RoomManager;
import me.dennis.exitfinder.types.Room;
import me.dennis.exitfinder.utils.KeyMap;

public class RoomPause extends Room {

	private float cx, cy;
	
	public BufferedImage image;
	
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
	public void beginDraw(Graphics g) {
		g.drawImage(image, 0, 0, null);
	}

	@Override
	public void endDraw(Graphics g) {
	}
	
	public void setVariables(float cx, float cy, Room room) {
		this.cx = cx;
		this.cy = cy;
	}
	
}
