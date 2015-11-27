package model.pojos;
import java.util.Date;

public class Member {
	
	/**
	 * L'identifiant du membre
	 */
	private int memberID;

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMemberContextID() {
		return memberContextID;
	}

	public void setMemberContextID(MemberContext memberContext) {
		this.memberContextID = memberContext.getId();
	}

	public int getMemberCredentialsID() {
		return memberCredentialsID;
	}

	public void setMemberCredentialsID(MemberCredentials memberCredentials) {
		this.memberCredentialsID = memberCredentials.getId();
	}

	public int getPostalAddressID() {
		return postalAddressID;
	}

	public void setPostalAddressID(PostalAddress postalAddress) {
		this.postalAddressID = postalAddress.getId();
	}

	public Member(String lastName, String firstName, String pseudo, Date birthDate, int phoneNumber, String email,
			MemberContext memberContext, MemberCredentials memberCredentialsID, PostalAddress postalAddress) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.pseudo = pseudo;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.memberContextID = memberContext.getId();
		this.memberCredentialsID = memberCredentials.getId();
		this.postalAddressID = postalAddress.getId();
	}

	public Member(int memberID, String lastName, String firstName, String pseudo, Date birthDate, int phoneNumber,
			String email, MemberContext memberContext, MemberCredentials memberCredentialsID, PostalAddress postalAddress) {
		super();
		this.memberID = memberID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.pseudo = pseudo;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.memberContextID = memberContext.getId();
		this.memberCredentialsID = memberCredentials.getId();
		this.postalAddressID = postalAddress.getId();
	}

	/**
	 * Le nom du membre
	 */
	private String lastName;

	/**
	 * Le prénom du membre
	**/

	private String firstName;

	/**
	 * Le pseudo du membre
	 */
	private String pseudo;

	/**
	 * Le prénom du membre
	**/

	private Date birthDate;
	
	/**
	 * Le téléphone du membre
	**/

	private int phoneNumber;
	
	/**
	 * Le mail du membre
	**/

	private String email;
	
	/**
	 * L'identifiant de la table MemberContext
	 */
	private int memberContextID;
	
	/**
	 * L'identifiant de la table MemberCredentials
	 */
	private int memberCredentialsID;
	
	/**
	 * L'identifiant de la table PostalAddress
	 */
	private int postalAddressID;
}
