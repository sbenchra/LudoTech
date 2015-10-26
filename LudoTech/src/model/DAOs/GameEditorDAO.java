package model.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe manipulant des objets de type GameEditor dans la base de données
 *
 */
public class GameEditorDAO extends DAO {

	/**
	 * Cherche l'identifiant d'un éditeur de jeu (le créé s'il n'existe pas encore)
	 * @param gameEditor Le nom de l'éditeur de jeu
	 * @return L'identifiant de l'éditeur de jeu 
	 */
	public int getID(String gameEditor) {
		
		int idFound = -1;
		
		try {
			super.connect();

			PreparedStatement psSelect = connection.prepareStatement(
					"SELECT id FROM GAME_EDITOR WHERE name = ?");
			psSelect.setString(1, gameEditor.toLowerCase());
			psSelect.execute();
			
			ResultSet idRS = psSelect.getResultSet();
			if (idRS != null && idRS.next()) { // L'identifiant a été trouvé
				idFound = idRS.getInt(1);
			} else {
				PreparedStatement psInsert = connection.prepareStatement(
						"INSERT INTO GAME_EDITOR(name) VALUES (?)", new String[] { "ID" });
				psInsert.setString(1, gameEditor.toLowerCase());
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
