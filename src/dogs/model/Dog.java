package dogs.model;

public class Dog extends Entity{  // La classe est tr�s simple ici mais il pourrait avoir des validations ou des algos plus complexes.
	
	private String name;
	private String breed;
	private float weight;
	private Customer owner;
	
	public Dog(String name, String breed, float weight, Customer owner) {
		super();
		this.name = name;
		this.breed = breed;
		this.weight = weight;
		this.owner = owner;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	public float getWeight() {
		return this.weight;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public Customer getOwner() {
		return this.owner;
	}
	
	public void setOwner(Customer customer) {
		this.owner = customer;
	}

}
