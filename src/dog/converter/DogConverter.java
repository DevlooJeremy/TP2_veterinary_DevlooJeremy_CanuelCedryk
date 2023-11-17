package dog.converter;

import dogs.model.Dog;
import dto.DogDTO;

public class DogConverter {

	public Dog dtoToDog(DogDTO dogDTO) {
		Dog dog = new Dog(dogDTO.name,dogDTO.breed);
		dog.setId(dogDTO.id);
		return dog;
	}
	
	public DogDTO dogToDTO(Dog dog) {
		return new DogDTO(dog.getName(),dog.getBreed(),dog.getId());
	}
}
