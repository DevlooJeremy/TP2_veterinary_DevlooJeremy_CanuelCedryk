package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dogs.controller.DogController;
import dogs.model.Customer;
import dogs.model.Dog;
import dto.CustomerDTO;
import dto.DogDTO;
import mock.RepositorySpy;
import mock.RepositoryStub;

class DogControllerTest {

	@Test
	void dogControllerCanAddDogToRepository() {
		//Arrange
		RepositorySpy<Dog> repository = new RepositorySpy<Dog>();
		RepositoryStub<Customer> customerRepository = new RepositoryStub<Customer>();
		customerRepository.add(new Customer(null,"Machin",null,null));
		DogController dogController = new DogController(repository,customerRepository);
		CustomerDTO customerDTO = new CustomerDTO(null,"Machin",null,null,0);
		DogDTO dogDTO = new DogDTO("Jean","Boxer",0,25.0f,customerDTO);
		
		//Act
		dogController.add(dogDTO);
		
		//Assert
		assertTrue(repository.hasAddBeenCalled);
		assertEquals("Jean", repository.elementAdded.getName());
		assertEquals("Boxer", repository.elementAdded.getBreed());
		assertTrue(dogController.verifyIfOwnerExist("Machin"));
	}

}
