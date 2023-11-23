package dogs.model;

public class Customer {
	
	private int id;
	private String name;
	private String lastName;
	private String phoneNumber;
	private String email;
	
	public Customer(String name, String lastName, String phoneNumber, String email) {
		this.name = name;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setPhone(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhone() {
		return this.phoneNumber;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
}