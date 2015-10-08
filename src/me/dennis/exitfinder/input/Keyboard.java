package me.dennis.exitfinder.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Keyboard implements KeyListener {

	private List<Boolean> keys = new ArrayList<Boolean>();
	private List<Boolean> pkeys = new ArrayList<Boolean>();
	private List<Boolean> rkeys = new ArrayList<Boolean>();
	
	public void setupKeys() {
		for (int i = 0; i < KeyEvent.KEY_LAST; i++) {
			keys.add(false);
			pkeys.add(false);
			rkeys.add(false);
		}
	}
	
	public void reset() {
		for (int i = 0; i < keys.size(); i++) {
			pkeys.set(i, false);
			rkeys.set(i, false);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		pkeys.set(event.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent event) {
		rkeys.set(event.getKeyCode(), true);
	}

	@Override
	public void keyTyped(KeyEvent event) {}

}
