package dto;
import java.util.Map;

public class DogDTO {
	
	public final String breed;
	public final String name;
	public final int id;
	
	
	public DogDTO(String name, String breed,int id) {
		this.breed = breed;
		this.name = name;
		this.id = id;
	}
	

}
