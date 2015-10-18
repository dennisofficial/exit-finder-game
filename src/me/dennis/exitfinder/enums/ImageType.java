package me.dennis.exitfinder.enums;

public enum ImageType {

	BLOCK("blocks/");
	
	private String path;
	
	private ImageType(String path) {
		this.path = path;
	}
	
	public String getFolder() {
		return path;
	}
	
}
