package nure.itkn.malyk.usermanagement;
import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;

class User implements Serializable {
	private static final long serialVersionUID = -4186523343377560524L;
	private Long id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	
	public User() {
	  firstName = "";
	  lastName = "";
	}
	
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
	
	/**
   * public String getFullName()
   * requires: нет ограничений
   * effects: полное имя пользоватея в формате lastName + " ," + firstName.
   */
	public String getFullName() {
	  StringBuilder fullName = new StringBuilder();
	  fullName.append(this.lastName);
	  fullName.append(", ");
	  fullName.append(this.firstName);
	  return fullName.toString();
	}
	
	/**
   * public int getAge()
   * requires: нет ограничений
   * effects: возраст пользователя. 
   * Если дата рождения больше текущей даты, выбрасывается исключение IllegalArgumentException
   */
	public int getAge() {
	  Calendar current_date = Calendar.getInstance();
	  current_date.setTime(new Date());
	  Calendar birth_date = Calendar.getInstance();
	  birth_date.setTime(this.getDateOfBirth());
	  
	  if(birth_date.after(current_date)) {
	    throw new IllegalArgumentException("bad date");
	  }
	  
	  int age = current_date.get(Calendar.YEAR) - birth_date.get(Calendar.YEAR);
	  if(birth_date.get(Calendar.MONTH) <= current_date.get(Calendar.MONTH)) {
	    if (birth_date.get(Calendar.DAY_OF_MONTH) <= current_date.get(Calendar.DAY_OF_MONTH)) {
	      return age;
	    } else {
	      return (age-1);
	    }
	  } else {
	    return (age-1);
	  }
	}
}
