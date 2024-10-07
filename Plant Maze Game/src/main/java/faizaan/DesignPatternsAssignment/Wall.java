package faizaan.DesignPatternsAssignment;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class Wall extends GameObject {
	

	public Wall(GraphicsContext gc, double x, double y, int width, int height) {
		super(gc, x, y, width, height);
		img=new Image(Seed.class.getResource("wall.png").toExternalForm());
	}
	
	public void update() {
		super.update();
		updateRectangle();
	}
	
}
