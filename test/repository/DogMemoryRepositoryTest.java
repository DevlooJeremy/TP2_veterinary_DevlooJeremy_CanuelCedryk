package repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dogRepository.DogMemoryRepository;
import dogRepository.IDogRepository;
import dogs.model.Dog;

class DogMemoryRepositoryTest {

	@Test
	void newDogCanBeAddedToRepository() {
		//Arrange
		Dog dog = new Dog("Jean","Machin");
		IDogRepository repository = new DogMemoryRepository();
		
		//Act
		repository.add(dog);
		
		//Assert
		assertEquals(1,repository.size());
		assertTrue(repository.getList().contains(dog));
		assertTrue(repository.searchById(1).equals(dog));
	}

}
