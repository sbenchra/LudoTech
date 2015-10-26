package model.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
		Assert.assertNotNull(gameServices.addGame("TestAddGame1", "Salut, je suis une description", 2015, 12, 2, 4, "Cartes", "Marco"));
		Assert.assertNotNull(gameServices.addGame("TestAddGame2", "Coucou, moi j'en suis une autre", 2011, 4, 1, 2, "Plateau", "Marco"));
	}

	@Test
	public void testEditGames() {
		// Ajout du jeu à modifier
		Game editableGame = gameServices.addGame("TestEditGame1", "Ancienne description", 2015, 8, 2, 6, "Dés", "Machin");
		Assert.assertNotNull(editableGame);

		// Modification du jeu
		Assert.assertNotNull(gameServices.editGame(editableGame.getGameID(), editableGame.getName(),
				"Nouvelle description", editableGame.getPublishingYear(), editableGame.getMinimumAge(),
				editableGame.getMinimumPlayers(), editableGame.getMaximumPlayers(), editableGame.getCategory(),
				editableGame.getEditor()));
	}

}
