package faizaan.DesignPatternsAssignment;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class mainApp extends Application {
	View view;
	Model model;
	Controller controller;

	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Plant Cycle Maze");
		Pane root = new Pane();
		Scene scene = new Scene(root,800,600);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		model = new Model();
		view = new View(root,model, scene);
		controller = new Controller(model,view);
	}

}
