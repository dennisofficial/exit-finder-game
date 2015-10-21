package me.dennis.exitfinder.input;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class Mouse implements MouseListener, MouseMotionListener {

	private List<Boolean> keys = new ArrayList<Boolean>();
	private List<Boolean> pkeys = new ArrayList<Boolean>();
	private List<Boolean> rkeys = new ArrayList<Boolean>();

	private Point point = new Point(0, 0);
	
	public void setupKeys() {
		for (int i = 0; i < 4; i++) {
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
	
	public Boolean isDirect(Integer key) {
		return keys.get(key);
	}
	
	public Boolean isPressed(Integer key) {
		return pkeys.get(key);
	}
	
	public Boolean isReleased(Integer key) {
		return rkeys.get(key);
	}
	
	public Point getPoint() {
		return point;
	}
	
	@Override
	public void mouseMoved(MouseEvent event) {
		point.setLocation(event.getPoint());
	}
	
	@Override
	public void mouseDragged(MouseEvent event) {
		point.setLocation(event.getPoint());
	}
	
	@Override
	public void mousePressed(MouseEvent event) {
		keys.set(event.getButton(), true);
		pkeys.set(event.getButton(), true);
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		keys.set(event.getButton(), false);
		rkeys.set(event.getButton(), true);
	}

	@Override
	public void mouseClicked(MouseEvent event) {}
	@Override
	public void mouseEntered(MouseEvent event) {}
	@Override
	public void mouseExited(MouseEvent event) {}

}
