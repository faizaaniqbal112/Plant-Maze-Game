package faizaan.DesignPatternsAssignment;


import faizaan.DesignPatternsAssignment.View.Context;
import faizaan.DesignPatternsAssignment.View.Map1;
import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Controller implements EventHandler {
	Model model;
	View view;
	
	boolean collision = false;
	
	public Controller(Model model, View view) {
		super();
		this.model = model;
		this.view = view;
		this.view.startButton.setOnAction(this);
	}
	
	public void updateView() {
		view.updateView();
	}
	
	@Override
	public void handle(Event event) {
		if(event.getSource() == this.view.startButton) {
			model.nextLevel();
			this.view.startButton.setVisible(false);
			this.view.help.setVisible(false);
			this.view.titleLabel.setVisible(false);
			move();
			updateView();
		}
	}

	
	
	public void move() {
	
		 EventHandler<KeyEvent> keyHandler = new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) { //key listener to detect the way user wants to move
				//if there is collision with wall object doesn't allow user to move into it
			
				if(event.getCode() == KeyCode.D) {
					if(!collision) {
					view.seed.moveRight();
					}else if(collision) {
						view.seed.x -=5;
					}
				}
				if(event.getCode() == KeyCode.A) {
					if(!collision) {
					view.seed.moveLeft();
					}else if(collision) {
						view.seed.x += 5;
						
					}
				}
				if(event.getCode() == KeyCode.W) {
					if(!collision) {
					view.seed.moveUp();
					}else if(collision) {
						view.seed.y +=5;
					}
				}
				if(event.getCode() == KeyCode.S) {
					if(!collision) {
					view.seed.moveDown();
					}else if(collision) {
						view.seed.y -= 5;
					}
				}
				collision = false;
			}
		}; 
		
		AnimationTimer timer = new AnimationTimer() {

			@Override
			public void handle(long args0) {
				view.gc.setFill(Color.GREEN);
				view.gc.fillRect(0, 0, view.canvas.getWidth(), view.canvas.getHeight());
				
				if(model.getLevel() == 1) { 
					
					view.seed.update();
					for(Wall wall: model.borderWalls) {
						wall.update();
					}
					view.soil.update();
				}else if(model.getLevel() == 2) {
					
					view.seed.update(); 
					for(Wall wall: model.borderWalls) {
						wall.update();
					}
					view.soil.update();
				}else if(model.getLevel() == 3) {
					
					view.seed.update(); 
					for(Wall wall: model.borderWalls) {
						wall.update();
					}
					view.soil.update();
				}
				for(Wall wall: model.borderWalls) {
					if (view.seed.r.intersects(wall.r.getX(), wall.r.getY(), wall.r.getWidth(), wall.r.getHeight())){
						collision = true;
					 }	
				}
				if(view.seed.r.intersects(view.soil.r.getX(), view.soil.r.getY(), view.soil.r.getWidth(), view.soil.r.getHeight())){
					model.nextLevel();
					updateView();
					if(model.getLevel() == 2) {
					view.seed = new Seedling(view.gc, 0, 0, 75, 75);
					view.soil = new WaterAndSun(view.gc,575,425,50,50);
					}
					else if(model.getLevel() == 3) {
						view.seed = new Flower(view.gc, 0, 0, 75, 75);
						view.soil = new WaterAndSun(view.gc,575,425,50,50);
					}
				}
					
			}
		};
		
		timer.start();
		view.scene.setOnKeyPressed(keyHandler);	
	}
}
