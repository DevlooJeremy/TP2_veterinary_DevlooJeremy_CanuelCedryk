package repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dogRepository.EntityMemoryRepository;
import dogRepository.IEntityRepository;
import dogs.model.Customer;
import dogs.model.Dog;
import dogs.searcher.CustomerSearcherFabric;

class EntityMemoryRepositoryTest {

	private static final String NAME = "Jean";
	private static final String LAST_NAME = "Machin";
	
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
	
	@Test
	void newCustomerCanBeAddedToRepository() {
		//Arrange
		Customer customer = new Customer(NAME,LAST_NAME, null, null);
		IEntityRepository<Customer> repository = new EntityMemoryRepository<Customer>();
		
		//Act
		repository.add(customer);
		
		//Assert
		assertEquals(1,repository.size());
		assertTrue(repository.getList().contains(customer));
		assertTrue(repository.search(new CustomerSearcherFabric().getStrategyToResearchCustomerById(1)).contains(customer));
		assertTrue(repository.search(new CustomerSearcherFabric().getStrategyToResearchCustomerByName(LAST_NAME)).contains(customer));
		assertFalse(repository.search(new CustomerSearcherFabric().getStrategyToResearchCustomerById(2)).contains(customer));
		assertFalse(repository.search(new CustomerSearcherFabric().getStrategyToResearchCustomerByName(NAME)).contains(customer));
	}

}
