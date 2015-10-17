package me.dennis.exitfinder.enums;

public enum FileType {

	LEVEL("levels/", ".lvl");
	
	private String extension;
	private String folder;
	
	private FileType(String folder, String extension) {
		this.folder = folder;
		this.extension = extension;
	}
	
	public String getExt() {
		return extension;
	}
	
	public String getFolder() {
		return folder;
	}
	
}
