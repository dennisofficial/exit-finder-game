package me.dennis.exitfinder.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import me.dennis.exitfinder.enums.Level;
import me.dennis.exitfinder.types.GameObject;

public class MapLoader {

	public List<GameObject> loadLevel(Level level) {
		List<GameObject> output = new ArrayList<GameObject>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(level.getFile()));
			
			String levelData = reader.readLine();
			String[] groups = levelData.split(";");
			for (String group : groups) {
				String[] props = group.split(",");
				try {
					Object object = Class.forName("me.dennis.exitfinder.objects." + props[0])
					.getConstructor(Integer.class, Integer.class)
					.newInstance(new Integer(props[1]), new Integer(props[2]));
					output.add((GameObject) object);
				}
				catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException
						| ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			
			reader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}
	
}
