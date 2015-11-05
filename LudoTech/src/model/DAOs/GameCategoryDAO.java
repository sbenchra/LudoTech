package model.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe manipulant des objets de type GameCategory dans la base de données
 *
 */
public class GameCategoryDAO extends DAO {

	/**
	 * Cherche l'identifiant d'une catégorie de jeu (la créer si elle n'existe
	 * pas encore)
	 * 
	 * @param gameCategory
	 *            Le nom de la catégorie de jeu
	 * @return L'identifiant de la catégorie de jeu
	 */
	public int getID(String gameCategory) {

		int idFound = -1;

		try {
			super.connect();

			PreparedStatement psSelect = connection.prepareStatement("SELECT ID FROM GAME_CATEGORY WHERE category = ?");
			psSelect.setString(1, gameCategory.toLowerCase());
			psSelect.execute();

			ResultSet idRS = psSelect.getResultSet();
			if (idRS != null && idRS.next()) { // L'identifiant a été trouvé
				idFound = idRS.getInt(1);
			} else {
				PreparedStatement psInsert = connection
						.prepareStatement("INSERT INTO GAME_CATEGORY(category) VALUES (?)", new String[] { "ID" });
				psInsert.setString(1, gameCategory.toLowerCase());
				psInsert.executeUpdate();

				// Récupération de l'identifiant généré automatiquement par Derby
				idRS = psInsert.getGeneratedKeys();
				if (idRS != null && idRS.next()) {
					idFound = idRS.getInt(1);
				} else {
					throw new SQLException();
				}
			}

			super.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idFound;
	}
}
