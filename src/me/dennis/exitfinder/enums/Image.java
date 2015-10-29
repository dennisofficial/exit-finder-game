package me.dennis.exitfinder.enums;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import me.dennis.exitfinder.types.GameFile;

public enum Image {

	// SLABS
	GRASS_SLAB("grass", ImageType.SLAB),
	
	// BLOCKS
	DIRT("dirt", ImageType.BLOCK),
	GRASS("grass", ImageType.BLOCK),
	CURSOR("cursor", ImageType.BLOCK),
	WOOD("wood", ImageType.BLOCK),
	
	// BUTTONS
	B_CONTINUE("continue", ImageType.BUTTON),
	B_QUIT("quit", ImageType.BUTTON),
	B_OPTIONS("options", ImageType.BUTTON),
	B_EXIT("exit", ImageType.BUTTON),
	B_NEW_GAME("new-game", ImageType.BUTTON);

	private GameFile file;
	
	private Image(String path, ImageType type) {
		file = new GameFile(type.getFolder() + path, FileType.IMAGE);
	}
	
	public GameFile getFile() {
		return file;
	}
	
	public BufferedImage getImage() {
		try {
			return ImageIO.read(file);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
