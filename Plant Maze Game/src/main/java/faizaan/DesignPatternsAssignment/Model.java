package faizaan.DesignPatternsAssignment;

import java.util.ArrayList;

public class Model {
	int level = 0;
	
	ArrayList<Wall> borderWalls = new ArrayList<Wall>();
		
	
	public void nextLevel(){
		level += 1;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void addBorderWall(Wall wall) {
		borderWalls.add(wall);
	}
}
