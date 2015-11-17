package model.services;

import java.util.List;

import model.pojos.Game;

/**
 * Interface d'accès au modèle et aux traitements métiers réalisés par des services
 */
public interface ServicesInterface {

	/**
	 * Obtention de la liste des jeux
	 * @return La liste des jeux
	 */
	public abstract List<Game> getGameList();
	
}
