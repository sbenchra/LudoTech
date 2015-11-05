package model.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.pojos.MemberContext;

/**
 * Classe manipulant des objets de type MemberContext dans la base de données
 */
public class MemberContextDAO extends DAO {
	
	public boolean add(MemberContext memberContext) {

		try {
			super.connect();

			PreparedStatement psInsert = connection
					.prepareStatement(
							"INSERT INTO "
									+ "MEMBER_CONTEXT(nb_delays, nb_fake_bookings, last_subscription_date, can_borrow, can_book) "
									+ "VALUES (?, ?, ?, ?, ?)",
							new String[] { "ID" });
			psInsert.setInt(1, memberContext.getNbDelays());
			psInsert.setInt(2, memberContext.getNbFakeBookings());
			psInsert.setDate(3, memberContext.getLastSubscriptionDate());
			psInsert.setBoolean(4, memberContext.canBorrow());
			psInsert.setBoolean(5, memberContext.canBook());

			psInsert.executeUpdate();

			// Récupération de l'identifiant du contexte d'un membre généré
			// automatiquement par Derby
			ResultSet idRS = psInsert.getGeneratedKeys();
			if (idRS != null && idRS.next()) {
				memberContext.setId(idRS.getInt(1));
			} else {
				throw new SQLException();
			}

			super.disconnect();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean edit(MemberContext memberContext) {

		try {
			super.connect();

			PreparedStatement psEdit = connection
					.prepareStatement("UPDATE MEMBER_CONTEXT "
							+ "SET nb_delays = ?, nb_fake_bookings = ?, last_subscription_date = ?, can_borrow = ?, can_book = ?"
							+ "WHERE id = ?");
			psEdit.setInt(1, memberContext.getNbDelays());
			psEdit.setInt(2, memberContext.getNbFakeBookings());
			psEdit.setDate(3, memberContext.getLastSubscriptionDate());
			psEdit.setBoolean(4, memberContext.canBorrow());
			psEdit.setBoolean(5, memberContext.canBook());
			psEdit.setInt(6, memberContext.getId());

			psEdit.executeUpdate();
			psEdit.closeOnCompletion();

			super.disconnect();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean remove(MemberContext memberContext) {
		try {
			PreparedStatement psRemove = connection
					.prepareStatement("REMOVE FROM " + "MEMBER_CONTEXT WHERE "
							+ "id = ?");
			psRemove.setInt(1, memberContext.getId());
			psRemove.execute();
			psRemove.closeOnCompletion();

			super.disconnect();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
