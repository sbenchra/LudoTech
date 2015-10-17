package model.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.enums.GameCategory;
import model.pojos.Game;
import model.services.GameServices;

/**
 * Tests sur la manipulation de jeux
 * 
 * @author Théo Gauchoux
 *
 */
public class GameTests extends Tests {

	/**
	 * L'objet exposant les services liés aux jeux
	 */
	private GameServices gameServices;

	@Before
	public void before() {
		this.gameServices = new GameServices();
		super.before();
	}

	@Test
	public void testAddGames() {
		Assert.assertNotNull(gameServices.addGame("TestAddGame1", "Salut je suis une description", GameCategory.CARTES,
				"Marco", "Polo", 2015, 4));
		Assert.assertNotNull(gameServices.addGame("TestAddGame2", "Avec une description", GameCategory.DES,
				"Un éditeur", "Un auteur", 2014, 2));
	}

	@Test
	public void testEditGames() {
		// Ajout du jeu à modifier
		Game editableGame = gameServices.addGame("TestEditGame", "Une description modifiable", GameCategory.PLATEAU,
				"Polytech", "Montpellier", 2015, 3);
		Assert.assertNotNull(editableGame);
		
		// Modification du jeu
		Assert.assertNotNull(gameServices.editGame(editableGame.getGameID(), editableGame.getName(),
				"Nouvelle description", editableGame.getCategory(), editableGame.getEditor(), editableGame.getAuthor(),
				editableGame.getPublishingYear(), editableGame.getNbPlayers()));
	}

}
