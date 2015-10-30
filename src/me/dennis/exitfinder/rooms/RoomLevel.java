package me.dennis.exitfinder.rooms;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import me.dennis.exitfinder.core.Camera;
import me.dennis.exitfinder.enums.Level;
import me.dennis.exitfinder.enums.RoomEnum;
import me.dennis.exitfinder.input.Keyboard;
import me.dennis.exitfinder.managers.CloudManager;
import me.dennis.exitfinder.managers.RoomManager;
import me.dennis.exitfinder.types.Background;
import me.dennis.exitfinder.types.Room;
import me.dennis.exitfinder.utils.KeyMap;
import me.dennis.exitfinder.utils.MapLoader;
import me.dennis.exitfinder.utils.Settings;

public class RoomLevel extends Room {

	Background bg = new Background(0xACD7FF);
	CloudManager cm = new CloudManager();
	
	@Override
	public void init() {
		objects.addAll(MapLoader.loadLevel(Level.W0L1));
	}

	@Override
	public void update() {
		cm.update();
		if (Keyboard.isPressed(KeyMap.menuPause())) {
			// Image create
			BufferedImage image = new BufferedImage(Settings.width, Settings.height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();
			
			// Artificial Draw
			g.translate((int) Camera.x, (int) Camera.y);
			RoomManager.draw(g);
			g.translate((int) -Camera.x, (int) -Camera.y);
			
			// Set variables
			RoomPause room = (RoomPause) RoomEnum.PAUSE.room;
			room.image = image;
			RoomManager.setRoom(RoomEnum.PAUSE);
			
			// Save Variables
			room.setVariables(Camera.x, Camera.y, this);
			
			// Camera reset
			Camera.dx = Settings.width/2;
			Camera.dy = Settings.height/2;
			Camera.x = 0;
			Camera.y = 0;
		}
	}

	@Override
	public void beginDraw(Graphics g) {
		bg.draw(g);
		cm.draw(g);
	}

	@Override
	public void endDraw(Graphics g) {
	}

}
