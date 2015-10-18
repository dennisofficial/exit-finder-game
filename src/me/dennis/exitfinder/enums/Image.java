package me.dennis.exitfinder.enums;

import me.dennis.exitfinder.types.GameFile;

public enum Image {

	DIRT("dirt", ImageType.BLOCK),
	GRASS("grass", ImageType.BLOCK);

	private GameFile file;
	
	private Image(String path, ImageType type) {
		file = new GameFile(type.getFolder() + path, FileType.IMAGE);
	}
	
	public GameFile getFile() {
		return file;
	}
	
}
