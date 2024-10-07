package faizaan.DesignPatternsAssignment;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Seed extends GameObject {
	
	

	public Seed(GraphicsContext gc, double x, double y, int width, int height) {
		super(gc, x, y, width, height);
		img=new Image(Seed.class.getResource("seed.png").toExternalForm());
	}
	
	public void update() {
		super.update();
		this.updateRectangle();
	}
	
	public void moveLeft() {
		x-=5;
	}
	public void moveRight() {
		x+=5;
	}
	public void moveUp() {
		y-=5;
	}
	public void moveDown() {
		y+=5;
	}
	
	public void updateRectangle() {
		this.r.setX(this.x+40);
		this.r.setY(this.y+50);
		this.r.setHeight(this.height-70);
		this.r.setWidth(this.width-60);
	}
}
