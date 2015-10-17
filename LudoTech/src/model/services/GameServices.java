package model.services;

import model.DAOs.GameDAO;
import model.enums.GameCategory;
import model.pojos.Game;

/**
 * Expose des services de traitement sur des jeux
 * 
 * @author Théo Gauchoux
 *
 */
public class GameServices {

	/**
	 * Objet d'accès aux données de type Game
	 */
	private final GameDAO gameDAO;

	public GameServices() {
		this.gameDAO = new GameDAO();
	}

	/**
	 * Création et ajout en base de données d'un nouveau jeu
	 * 
	 * @param name
	 *            Le nom du nouveau jeu
	 * @param description
	 *            La description du nouveau jeu
	 * @param category
	 *            La catégorie du nouveau jeu
	 * @param editor
	 *            L'éditeur du nouveau jeu
	 * @param author
	 *            L'auteur du nouveau jeu
	 * @param publishingYear
	 *            L'année d'édition du nouveau jeu
	 * @param nbPlayers
	 *            Le nombre de joueurs recommandé du nouveau jeu
	 * @return Un objet de type Game s'il le jeu a pu être ajouté à la base de
	 *         données, sinon Null
	 */
	public Game addGame(String name, String description, GameCategory category, String editor, String author,
			int publishingYear, int nbPlayers) {
		Game game = new Game(name, description, category, editor, author, publishingYear, nbPlayers);
		return this.gameDAO.add(game) ? game : null;
	}

	/**
	 * Edition d'un jeu existant
	 * 
	 * @param gameID
	 *            L'identifiant du jeu
	 * @param name
	 *            Le nom du jeu
	 * @param description
	 *            La description du jeu
	 * @param category
	 *            La catégorie du jeu
	 * @param editor
	 *            L'éditeur du jeu
	 * @param author
	 *            L'auteur du jeu
	 * @param publishingYear
	 *            L'année d'édition du jeu
	 * @param nbPlayers
	 *            Le nombre de joueurs recommandé du jeu
	 * @return Un objet de type Game s'il le jeu a pu être modifié dans la base
	 *         de données, sinon Null
	 */
	public Game editGame(int gameID, String name, String description, GameCategory category, String editor,
			String author, int publishingYear, int nbPlayers) {
		Game game = new Game(gameID, name, description, category, editor, author, publishingYear, nbPlayers);
		return this.gameDAO.edit(game) ? game : null;
	}

}
