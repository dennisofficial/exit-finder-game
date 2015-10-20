package me.dennis.exitfinder.enums;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import me.dennis.exitfinder.types.GameFile;

public enum Image {

	DIRT("dirt", ImageType.BLOCK),
	GRASS("grass", ImageType.BLOCK),
	CURSOR("cursor", ImageType.BLOCK),
	GRASS_SLAB("grass", ImageType.SLAB);

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
