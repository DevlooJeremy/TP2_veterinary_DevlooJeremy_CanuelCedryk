package dto;

public class DogDTO {
	
	public final String breed;
	public final String name;
	public final float weight;
	public final CustomerDTO owner;
	public final int id;
	
	
	public DogDTO(String name, String breed,int id, Float weight, CustomerDTO owner) {
		this.breed = breed;
		this.name = name;
		this.weight = weight;
		this.owner = owner;
		this.id = id;
	}
	

}
