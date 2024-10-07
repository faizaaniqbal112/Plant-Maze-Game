package faizaan.DesignPatternsAssignment;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class View {
	Pane root;
	Scene scene;
	Model model;
	Button startButton;
	
	Label help;
	Label titleLabel;
	
	
	Canvas canvas = new Canvas(800,600);
	GraphicsContext gc = canvas.getGraphicsContext2D();
	
	Seed seed;
	Soil soil = new Soil(gc,575,425,50,50);
	
	Context context;
	
	public View(Pane root, Model model, Scene scene) {
		super();
		this.root = root;
		this.model = model;
		this.scene = scene;
		
		gc.setFill(Color.GREEN);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		root.getChildren().add(canvas);
			
		updateView();
		
	}
	
	
	public void updateView() {
		startButton = new Button("start");
		
		if(model.getLevel() == 0) {
		
			startButton.setPrefHeight(50);
			startButton.setPrefWidth(100);
			startButton.setLayoutX(325);
			startButton.setLayoutY(300);
			
			help = new Label("HELP: W to move Up, S to move Down, D to move left, A to move Left");
			titleLabel = new Label("Plant Growth Cycle");
			
			help.setPrefHeight(50);
			help.setPrefWidth(500);
			help.setLayoutX(225);
			help.setLayoutY(200);
			help.setTextFill(Color.YELLOW);
		
			titleLabel.setPrefHeight(50);
			titleLabel.setPrefWidth(500);
			titleLabel.setLayoutX(325);
			titleLabel.setLayoutY(150);
			titleLabel.setTextFill(Color.YELLOW);
			
			root.getChildren().addAll(startButton,help,titleLabel);
		}
		else if(model.getLevel() == 1) { //displays map for level 1
			Border border = new Border();

			Map1 map1 = new Map1();
			context = new Context(map1);
			context.execute();
		}
		else if(model.getLevel() == 2) { //displays map for level 2
			Border border = new Border();
			
			Map2 map2 = new Map2();
			context = new Context(map2);
			context.execute();
		}
		else if(model.getLevel() == 3) { //displays map for level 3
			Border border = new Border();
			
			Map3 map3 = new Map3();
			context = new Context(map3);
			context.execute();
		}
		else if(model.getLevel() == 4) { //displays complete game
			Label complete = new Label("GAME COMPLETE");
			
			complete.setPrefHeight(50);
			complete.setPrefWidth(500);
			complete.setLayoutX(325);
			complete.setLayoutY(150);
			complete.setTextFill(Color.YELLOW);
			
			root.getChildren().add(complete);
		}
	}
	interface StrategyInterface{
		public void execute();
	}
	
	class Map1 implements StrategyInterface { //level 1 view 
	
		@Override
		public void execute() {
			seed = new Seed(gc, 0, 0, 100, 100);
			
			Wall block1 = new Wall(gc,250,250,50,50);
			model.addBorderWall(block1);
			Wall block2 = new Wall(gc,250,300,50,50);
			model.addBorderWall(block2);
			Wall block3 = new Wall(gc,450,450,50,50);
			model.addBorderWall(block3);
			Wall block4 = new Wall(gc,450,400,50,50);
			model.addBorderWall(block4);
			Wall block5 = new Wall(gc,550,200,50,50);
			model.addBorderWall(block5);		
		}
	}
	
	class Map2 implements StrategyInterface { //level 2 view 
		
		@Override
		public void execute() {
			
			Wall block6 = new Wall(gc,250,350,50,50);
			model.addBorderWall(block6);
			Wall block7 = new Wall(gc,500,400,50,50);
			model.addBorderWall(block7);
			Wall block8 = new Wall(gc,300,300,50,50);
			model.addBorderWall(block8);
			Wall block9 = new Wall(gc,400,400,50,50);
			model.addBorderWall(block9);
		}
	}
	
	class Map3 implements StrategyInterface { //level 2 view 
		
		@Override
		public void execute() {
			
			Wall block10 = new Wall(gc,250,400,50,50);
			model.addBorderWall(block10);
			Wall block11 = new Wall(gc,250,450,50,50);
			model.addBorderWall(block11);
			Wall block12 = new Wall(gc,500,200,50,50);
			model.addBorderWall(block12);
			Wall block13 = new Wall(gc,500,250,50,50);
			model.addBorderWall(block13);
			Wall block14 = new Wall(gc,450,250,50,50);
			model.addBorderWall(block14);
		
		}
	}
	
	class Context{
		private StrategyInterface strategy;
		
		public Context(StrategyInterface strategy) {
			this.strategy = strategy;
		}
		
		public void set_strategy(StrategyInterface strategy) {
			this.strategy = strategy;
		}
		
		public void execute() {
			this.strategy.execute();
		}
	}
	
	class Border{
		public Border() {
			//walls at border top
			Wall wall = new Wall(gc,100,100, 50,50);
			model.addBorderWall(wall);
			Wall wall2 = new Wall(gc,150,100, 50,50);
			model.addBorderWall(wall2);
			Wall wall3 = new Wall(gc,200,100,50,50);
			model.addBorderWall(wall3);
			Wall wall4 = new Wall(gc,250,100, 50,50);
			model.addBorderWall(wall4);
			Wall wall5 = new Wall(gc,300,100, 50,50);
			model.addBorderWall(wall5);
			Wall wall6 = new Wall(gc,350,100,50,50);
			model.addBorderWall(wall6);
			Wall wall7 = new Wall(gc,400,100,50,50);
			model.addBorderWall(wall7);
			Wall wall8 = new Wall(gc,450,100, 50,50);
			model.addBorderWall(wall8);
			Wall wall9 = new Wall(gc,500,100, 50,50);
			model.addBorderWall(wall9);
			Wall wall10 = new Wall(gc,550,100,50,50);
			model.addBorderWall(wall10);
			Wall wall11 = new Wall(gc,600,100,50,50);
			model.addBorderWall(wall11);
			Wall wall12 = new Wall(gc,600,100,50,50);
			model.addBorderWall(wall12);
			Wall wall13 = new Wall(gc,650,100,50,50);
			model.addBorderWall(wall13);
			
			//walls at border left
			Wall wall14 = new Wall(gc,100,150,50,50);
			model.addBorderWall(wall14);
			Wall wall15 = new Wall(gc,100,200, 50,50);
			model.addBorderWall(wall15);
			Wall wall16 = new Wall(gc,100,350, 50,50);
			model.addBorderWall(wall16);
			Wall wall17 = new Wall(gc,100,400,50,50);
			model.addBorderWall(wall17);
			Wall wall18 = new Wall(gc,100,450,50,50);
			model.addBorderWall(wall18);
			Wall wall19 = new Wall(gc,100,500, 50,50);
			model.addBorderWall(wall19);
			
			//walls at border bottom
			Wall wall20 = new Wall(gc,150,500, 50,50);
			model.addBorderWall(wall20);
			Wall wall21 = new Wall(gc,200,500,50,50);
			model.addBorderWall(wall21);
			Wall wall22 = new Wall(gc,250,500, 50,50);
			model.addBorderWall(wall22);
			Wall wall23 = new Wall(gc,300,500, 50,50);
			model.addBorderWall(wall23);
			Wall wall24 = new Wall(gc,350,500,50,50);
			model.addBorderWall(wall24);
			Wall wall25 = new Wall(gc,400,500,50,50);
			model.addBorderWall(wall25);
			Wall wall26 = new Wall(gc,450,500, 50,50);
			model.addBorderWall(wall26);
			Wall wall27 = new Wall(gc,500,500, 50,50);
			model.addBorderWall(wall27);
			Wall wall28 = new Wall(gc,550,500,50,50);
			model.addBorderWall(wall28);
			Wall wall29 = new Wall(gc,600,500,50,50);
			model.addBorderWall(wall29);
			Wall wall30 = new Wall(gc,600,500,50,50);
			model.addBorderWall(wall30);
			Wall wall31 = new Wall(gc,650,500,50,50);
			model.addBorderWall(wall31);
			
			//walls at border right
			Wall wall32 = new Wall(gc,650,150,50,50);
			model.addBorderWall(wall32);
			Wall wall33 = new Wall(gc,650,200, 50,50);
			model.addBorderWall(wall33);
			Wall wall34 = new Wall(gc,650,250,50,50);
			model.addBorderWall(wall34);
			Wall wall35 = new Wall(gc,650,300,50,50);
			model.addBorderWall(wall35);
			Wall wall36 = new Wall(gc,650,350, 50,50);
			model.addBorderWall(wall36);
			Wall wall37 = new Wall(gc,650,400,50,50);
			model.addBorderWall(wall37);
			Wall wall38 = new Wall(gc,650,450,50,50);
			model.addBorderWall(wall38);
			Wall wall39 = new Wall(gc,650,500, 50,50);
			model.addBorderWall(wall39);
		}
	}
	
}
