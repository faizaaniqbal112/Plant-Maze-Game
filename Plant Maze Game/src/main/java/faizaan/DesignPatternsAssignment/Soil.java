package faizaan.DesignPatternsAssignment;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Soil extends GameObject{

	public Soil(GraphicsContext gc, double x, double y, int width, int height) {
		super(gc, x, y, width, height);
		img=new Image(Soil.class.getResource("soil.png").toExternalForm());
	}
	
	public void update() {
		super.update();
		//updateRectangle();
	}
}
