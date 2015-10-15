package model.DAOs;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.pojos.Game;

/**
 * Classe manipulant des objets de type Game dans la base de données
 * 
 * @author Théo Gauchoux
 *
 */
public class GameDAO extends DAO {

	/**
	 * Ajoute une nouvelle ligne avec les informations d'un jeu à la table Game
	 * Génération automatique (par Derby) de l'identifiant (clé primaire) de la
	 * ligne
	 * 
	 * @param game
	 * @return
	 */
	public boolean add(Game game) {
		try {
			super.connect();
			PreparedStatement psInsert = connection.prepareStatement(
					"INSERT INTO " + "Game(name, description, category, editor, author, publishing_year, nb_players) "
							+ "values (?, ?, ?, ?, ?, ?, ?)");
			psInsert.setString(1, game.getName());
			psInsert.setString(2, game.getDescription());
			psInsert.setString(3, game.getCategory().toString());
			psInsert.setString(4, game.getEditor());
			psInsert.setString(5, game.getAuthor());
			psInsert.setInt(6, game.getPublishingYear());
			psInsert.setInt(7, game.getNbPlayers());

			psInsert.execute();
			psInsert.closeOnCompletion();

			super.disconnect();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean edit(Game game) {
		try {
			super.connect();
			PreparedStatement psEdit = connection
					.prepareStatement("UPDATE TABLE Game "
							+ "SET name = values (?)"
							+ "SET description = values (?)" 
							+ "SET category = values (?)"
							+ "SET editor = values (?)"
							+ "SET author = values (?)"
							+ "SET publishing_year = values (?)"
							+ "SET nb_players = values (?)"
							+ "WHERE id = (?)");
			
			 psEdit.setInt(8, game.getIdGame()); 
			 psEdit.setString(1, game.getName());
			 psEdit.setString(1,game.getDescription()); 
			 psEdit.setString(2, game.getCategory().toString()); 
			 psEdit.setString(3,game.getEditor()); 
			 psEdit.setString(4, game.getAuthor());
			 psEdit.setInt(5, game.getPublishingYear()); 
			 psEdit.setInt(6,game.getNbPlayers());
			 
			psEdit.execute();
			psEdit.closeOnCompletion();

			super.disconnect();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
