package dogs.model;

public class Dog extends Entity{  // La classe est tr�s simple ici mais il pourrait avoir des validations ou des algos plus complexes.
	
	private String name;
	private String breed;  // Id�alement faire une classe Breed (pr�f�rer � une enum)
	
	public Dog(String name, String breed) {
		super();
		this.name = name;
		this.breed = breed;
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

}
