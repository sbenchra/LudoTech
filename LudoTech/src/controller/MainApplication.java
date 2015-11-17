package controller;

import java.io.IOException;

import controller.catalog.GameListController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.services.Services;
import model.services.ServicesInterface;

/**
 * Classe principale de l'application faisant office de lanceur et gérant l'interface graphique
 */
public class MainApplication extends Application {

	/**
	 * Théâtre de l'application (la fenêtre principale)
	 */
	private Stage mainStage;
	
	/**
	 * Vue principale regroupant tous les éléments graphiques (onglets et leur contenu compris)
	 */
	private BorderPane mainView;
	
	/**
	 * Interface d'accès aux traitements métiers de l'application
	 */
	private ServicesInterface services;
	
    public MainApplication() {
    	this.services = new Services();
    }
    
    /**
     * Lanceur de l'application
     */
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage mainStage) {
		this.mainStage = mainStage;
		this.mainStage.setTitle("LudoTech");
		try {
			FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/view/MainView.fxml"));
			this.mainView = (BorderPane) loader.load();
			Scene scene = new Scene(mainView);
			mainStage.setScene(scene);
			mainStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		showGameListView();
	}
	
	/**
	 * Affichage de la vue listant les jeux dans l'onglet "Catalogue"
	 */
	public void showGameListView() {
	    try {
	    	FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/view/catalog/GameListView.fxml"));
			
			AnchorPane overviewPage = (AnchorPane) loader.load();
			TabPane tabPane = (TabPane) mainView.getCenter();
			tabPane.getTabs().get(1).setContent(overviewPage);
			GameListController controller = loader.getController();
			
			controller.setServices(this.services);
			controller.loadData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ServicesInterface getServices() {
		return this.services;
	}

}
