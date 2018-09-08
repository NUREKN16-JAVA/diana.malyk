package nure.itkn.malyk.usermanagement;
import java.util.Date;
import java.io.Serializable;

class User implements Serializable {
	private static final long serialVersionUID = -4186523343377560524L;
	private Long id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	
	public User(Long id, String firstName, String lastName, Date dateOfBirth) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setDateOfBirth(dateOfBirth);
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
}
