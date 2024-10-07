package faizaan.DesignPatternsAssignment;

import faizaan.DesignPatternsAssignment.View.StrategyInterface;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class WaterAndSun extends Soil{
	private StrategyInterface strategy;

	public WaterAndSun(GraphicsContext gc, double x, double y, int width, int height) {
		super(gc, x, y, width, height);
		img=new Image(Seed.class.getResource("Water and Sun.png").toExternalForm());
	}
	
	public void update() {
		super.update();
		}
}
