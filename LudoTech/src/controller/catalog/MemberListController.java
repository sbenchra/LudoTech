package controller.catalog;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.pojos.Game;
import model.services.MemberServices;
import controller.observable.ObservableMember;

public class MemberListController {

	/**
	 * Table JavaFX listant les jeux
	 */
	@FXML
	private TableView<ObservableMember> memberTable;
	
	/**
	 * Colonne JavaFX listant les identifiants des membres
	 */
	@FXML
	private TableColumn<ObservableMember, String> idColumn;
	
	/**
	 * Colonne JavaFX listant les noms des membres
	 */
	@FXML
	private TableColumn<ObservableMember, String> firstNameColumn;
	
	/**
	 * Colonne JavaFX listant les prénoms des membres
	 */
	@FXML
	private TableColumn<ObservableMember, String> lastNameColumn;
	
	/**
	 * Colonne JavaFX listant les ages des membres
	 */
	@FXML
	private TableColumn<ObservableGame, String> ageColumn;
	
	/**
	 * Colonne JavaFX listant les code postal des jeux
	 */
	@FXML
	private TableColumn<ObservableMember, String> postCodeColumn;
	
	/**
	 * Colonne JavaFX listant la ville
	 */
	@FXML
	private TableColumn<ObservableMember, String> CityColumn;
	
	/**
	 * Colonne JavaFX listant le payement de la cotisation
	 */
	@FXML
	private TableColumn<ObservableMember, String> payementColumn;
	
	/**
	 * Colonne JavaFX listant le statut ( emprunt / reservation )
	 */
	@FXML
	private TableColumn<ObservableMember, String> statusColumn;
	
	/**
	 * Services permettant l'accès aux traitements métiers de l'application
	 */
	private MemeberServices memberServices;
	
	public MemberListController() {
		this.memberServices = new MemberServices();
	}

	/**
	 * Initialisation de la correspondance entre les colonnes JavaFX et les propriétés de la classe observant des membres (ObservableMember)
	 */
	@FXML
	private void initialize() {
		this.idColumn.setCellValueFactory(new PropertyValueFactory<ObservableMember, String>("id"));
		this.firstNameColumn.setCellValueFactory(new PropertyValueFactory<ObservableMember, String>("name"));
		this.lastNameColumn.setCellValueFactory(new PropertyValueFactory<ObservableMember, String>("lastName"));
		this.ageColumn.setCellValueFactory(new PropertyValueFactory<ObservableMember, String>("age"));
		this.postCodeColumn.setCellValueFactory(new PropertyValueFactory<ObservableMember, String>("postCode"));
		this.CityColumn.setCellValueFactory(new PropertyValueFactory<ObservableMember, String>("city"));
		this.payementColumn.setCellValueFactory(new PropertyValueFactory<ObservableMember, String>("payement"));
		this.statusColumn.setCellValueFactory(new PropertyValueFactory<ObservableMember, String>("status"));
	}
	
	/**
	 * Chargement de la liste des jeux dans la table
	 */
	public void loadData() {
		ObservableList<ObservableMember> memberData = FXCollections.observableArrayList();
		for (Member member : this.memberServices.getGameList()) {
			memberData.add(new ObservableMember(member));
		}
		this.memberTable.setItems(memberData);
	}
	
	
}
