package faizaan.DesignPatternsAssignment;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Seedling extends Seed{

	public Seedling(GraphicsContext gc, double x, double y, int width, int height) {
		super(gc, x, y, width, height);
		img=new Image(Seed.class.getResource("seedling.png").toExternalForm());
		
	}
	
	public void update() {
		super.update();
		this.updateRectangle();
	}
	
	public void moveLeft() {
		super.moveLeft();
	}
	public void moveRight() {
		super.moveRight();
	}
	public void moveUp() {
		super.moveUp();
	}
	public void moveDown() {
		super.moveDown();
	}
	
	public void updateRectangle() {
		this.r.setX(this.x+40);
		this.r.setY(this.y+50);
		this.r.setHeight(this.height-70);
		this.r.setWidth(this.width-60);
	}
}
