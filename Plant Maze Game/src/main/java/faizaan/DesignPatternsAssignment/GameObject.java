package faizaan.DesignPatternsAssignment;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class GameObject {
	protected Image img;
	protected double x,y;
	protected int width, height;
	protected GraphicsContext gc;

	protected Rectangle r;
	
	public GameObject(GraphicsContext gc, double x, double y, int width, int height) {
		super();
		this.gc=gc;
		this.x=x;
		this.y=y;
		this.width = width;
		this.height = height;
		this.r = new Rectangle(0,0, this.width, this.height);
	}
	
	public void update() {
		if(img!=null) {
			gc.drawImage(img, x, y, this.width, this.height);
			updateRectangle();
		}
	}
	
	public void updateRectangle() {
		this.r.setX(this.x);
		this.r.setY(this.y);
		this.r.setHeight(this.height);
		this.r.setWidth(this.width);
	}
}
