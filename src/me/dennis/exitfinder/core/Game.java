package me.dennis.exitfinder.core;

import javax.swing.JFrame;

import me.dennis.exitfinder.utils.Settings;

public class Game {
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new Display());
		f.setVisible(true);
		f.setResizable(false);
		f.setSize(Settings.width, Settings.height);
		f.setLocationRelativeTo(null);
	}

}
