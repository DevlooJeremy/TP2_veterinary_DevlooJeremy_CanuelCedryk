package dto;
import java.util.Map;

import dogs.model.Customer;

public class DogDTO {
	
	public final String breed;
	public final String name;
	public final float weight;
	public final CustomerDTO owner;
	public final int id;
	
	
	public DogDTO(String name, String breed,int id, float weight, CustomerDTO owner) {
		this.breed = breed;
		this.name = name;
		this.weight = weight;
		this.owner = owner;
		this.id = id;
	}
	

}
