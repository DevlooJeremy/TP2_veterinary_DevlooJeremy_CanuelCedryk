package repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dogRepository.EntityMemoryRepository;
import dogRepository.IEntityRepository;
import dogs.model.Customer;
import dogs.model.Dog;

class EntityMemoryRepositoryTest {

	@Test
	void newDogCanBeAddedToRepository() {
		//Arrange
		Customer customer = new Customer("Jean","Sebastien","418-444-1919","courriel@gmail.com");
		Dog dog = new Dog("Jean","Machin",15.0f,customer);
		IEntityRepository<Dog> repository = new EntityMemoryRepository<Dog>();
		
		//Act
		repository.add(dog);
		
		//Assert
		assertEquals(1,repository.size());
		assertTrue(repository.getList().contains(dog));
		assertTrue(repository.searchById(0).equals(dog));
	}

}
