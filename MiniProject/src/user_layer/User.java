package user_layer;

public class User {

	public String Name, Surname,Email;
	public int Contacts, Password;
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getContacts() {
		return Contacts;
	}

	public void setContacts(int contacts) {
		Contacts = contacts;
	}

	public int getPassword() {
		return Password;
	}

	public void setPassword(int password) {
		Password = password;
	}
	
	public User() {
		
	}
	
	public User(String Name,String Surname, String Email, int Contacts,int Password) {
		
		this.Name = Name;
		this.Surname = Surname;
		this.Email = Email;
		this.Contacts = Contacts;
		this.Password = Password;
	}
	
}
