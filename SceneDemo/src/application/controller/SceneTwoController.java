package application.controller;

import application.Main;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SceneTwoController implements EventHandler<ActionEvent> {
	
	@FXML
	private AnchorPane anchorPane;
	
	@FXML
	private Label label;
	
	@FXML
	private Button button;
	
	@FXML
	public void initialize() {
		
		anchorPane.setOpacity(0);
		label.setText("Scene Two");
		button.setText("Next Scene");
		
		fadeInToCurrentScene();
	}

	@Override
	public void handle(ActionEvent event) {
		
		fadeOutToNextScene();
	}

	public void loadScene() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			
			loader.setLocation( Main.class.getResource("../SceneOne.fxml") );
			
			Stage stage = (Stage) button.getScene().getWindow();
			
			Scene scene = new Scene(loader.load());
			
			stage.setScene(scene);
		} 
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void fadeOutToNextScene() {
		
		FadeTransition fade = new FadeTransition();
		
		fade.setNode(anchorPane);
		
		fade.setFromValue(1);
		fade.setToValue(0);
		fade.setDuration(Duration.millis(1000));
		
		fade.play();
		
		fade.setOnFinished( (ActionEvent event) -> { loadScene(); } );
		
	}
	
	public void fadeInToCurrentScene() {
		
		FadeTransition fade = new FadeTransition();
		
		fade.setNode(anchorPane);
		
		fade.setFromValue(0);
		fade.setToValue(1);
		fade.setDuration(Duration.millis(1000));
		
		fade.play();
	}

}