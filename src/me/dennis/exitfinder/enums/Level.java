package me.dennis.exitfinder.enums;

import me.dennis.exitfinder.types.GameFile;

public enum Level {

	W0L1(new GameFile("0-1", FileType.LEVEL));
	
	private GameFile file;
	
	private Level(GameFile file) {
		this.file = file;
	}
	
	public GameFile getFile() {
		return file;
	}
	
}
