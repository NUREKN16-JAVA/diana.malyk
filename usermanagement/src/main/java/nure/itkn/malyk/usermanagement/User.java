package nure.itkn.malyk.usermanagement;
import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;

class User implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 6516265594737505284L;
  private Long id;
  private String firstName;
  private String lastName;
  private Date dateOfBirth;
  
	/* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
    result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    return result;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    User other = (User) obj;
    if (dateOfBirth == null) {
      if (other.dateOfBirth != null)
        return false;
    } else if (!dateOfBirth.equals(other.dateOfBirth))
      return false;
    if (firstName == null) {
      if (other.firstName != null)
        return false;
    } else if (!firstName.equals(other.firstName))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (lastName == null) {
      if (other.lastName != null)
        return false;
    } else if (!lastName.equals(other.lastName))
      return false;
    return true;
  }


	
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