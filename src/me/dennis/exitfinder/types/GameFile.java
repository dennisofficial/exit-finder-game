package me.dennis.exitfinder.types;

import java.io.File;

import me.dennis.exitfinder.enums.FileType;

@SuppressWarnings("serial")
public class GameFile extends File {

	public GameFile(String pathname, FileType type) {
		super(type.getFolder() + pathname + type.getExt());
	}
	
}
