package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApplication extends Application {

	private Stage primaryStage;
	private BorderPane mainView;

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("LudoTech");
		
		try {
			FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/view/MainView.fxml"));
			this.mainView = (BorderPane) loader.load();
			Scene scene = new Scene(mainView);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Stage getPrimaryStage() {
		return this.primaryStage;
	}
}
