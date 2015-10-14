package model.pojos;

import model.enums.GameCategory;

/**
 * Représentation d'un jeu (conforme à la table Game)
 * @author Théo Gauchoux
 *
 */
public class Game {

	/**
	 * Le nom du jeu
	 */
	private String name;
	
	/**
	 * La description du jeu
	 */
	private String description;
	
	/**
	 * La catégorie du jeu
	 */
	private GameCategory category;
	
	/**
	 * L'éditeur du jeu (l'entreprise le vendant)
	 */
	private String editor;
	
	/**
	 * L'auteur du jeu (la personne l'ayant créé)
	 */
	private String author;
	
	/**
	 * Année d'édition du jeu
	 */
	private int publishingYear;
	
	/**
	 * Nombre de joueurs recommandé pour ce jeu
	 */
	private int nbPlayers;

	public Game(String name, String description, GameCategory category, String editor, String author,
			int publishingYear, int nbPlayers) {
		this.name = name;
		this.description = description;
		this.category = category;
		this.editor = editor;
		this.author = author;
		this.publishingYear = publishingYear;
		this.nbPlayers = nbPlayers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public GameCategory getCategory() {
		return category;
	}

	public void setCategory(GameCategory category) {
		this.category = category;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublishingYear() {
		return publishingYear;
	}

	public void setPublishingYear(int publishingYear) {
		this.publishingYear = publishingYear;
	}

	public int getNbPlayers() {
		return nbPlayers;
	}

	public void setNbPlayers(int nbPlayers) {
		this.nbPlayers = nbPlayers;
	}

}
