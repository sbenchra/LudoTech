package model.services;

import java.util.List;

import model.pojos.Game;

/**
 * Classe permettant de dispatcher les traitements vers les services associés
 */
public class Services implements ServicesInterface {

	/**
	 * Services des jeux
	 */
	private GameServices gameServices;
	
	public Services() {
		this.gameServices = new GameServices();
	}
	
	/**
	 * Obtention de la liste des jeux
	 * @return La liste des jeux
	 */
	public List<Game> getGameList() {
		return this.gameServices.getGameList();
	}

}
