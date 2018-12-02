package nure.itkn.malyk.usermanagement;
import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;

public class User implements Serializable {
  /**
   * Represent entity "user"
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
	  if (this.getId() == null) {
		  return 0;
	  }
	  return this.getId().hashCode();
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
    	return false;
    }
    if (this == obj) {
    	return true;
    }
    if (this.getId() == null && ((User) obj).getId() == null) {
    	return true;
    }
    return this.getId().equals(((User) obj).getId());
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
	

	public User(String firstName, String lastName, Date dateOfBirth) {
		setFirstName(firstName);
		setLastName(lastName);
		this.dateOfBirth = dateOfBirth;
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
     * @throws:  IllegalArgumentException If date of birthday after current date
	 */
	public void setDateOfBirth(java.util.Date dateOfBirth) {
		Calendar current_date = Calendar.getInstance();
		current_date.setTime(new Date());
		Calendar birth_date = Calendar.getInstance();
		birth_date.setTime(dateOfBirth);
		  
		if(birth_date.after(current_date)) {
		  throw new IllegalArgumentException("bad date");
		} else {
			this.dateOfBirth = dateOfBirth;
		}
		
	}
	
	/**
   * @return: full user name in format "Surname, Name"
   */
	public String getFullName() {
	  StringBuilder fullName = new StringBuilder();
	  fullName.append(this.lastName);
	  fullName.append(", ");
	  fullName.append(this.firstName);
	  return fullName.toString();
	}
	
	/**
   * @return: the age of user
   */
	public int getAge() {
	  Calendar current_date = Calendar.getInstance();
	  current_date.setTime(new Date());
	  Calendar birth_date = Calendar.getInstance();
	  birth_date.setTime(this.getDateOfBirth());

	  int age = current_date.get(Calendar.YEAR) - birth_date.get(Calendar.YEAR);
	  if(birth_date.get(Calendar.MONTH) <= current_date.get(Calendar.MONTH)) {
	    if (birth_date.get(Calendar.DAY_OF_MONTH) <= current_date.get(Calendar.DAY_OF_MONTH)) {
	      return age;
	    }
	  }
	  return (age-1);
	}
}
