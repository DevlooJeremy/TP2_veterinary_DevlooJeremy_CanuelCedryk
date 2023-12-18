package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dogs.controller.DogController;
import dogs.model.Customer;
import dogs.model.Dog;
import dto.CustomerDTO;
import dto.DogDTO;
import mock.RepositorySpy;

class DogControllerTest {

	@Test
	void dogControllerCanAddDogToRepository() {
		//Arrange
		RepositorySpy<Dog> repository = new RepositorySpy<Dog>();
		RepositorySpy<Customer> customerRepository = new RepositorySpy<Customer>();
		DogController dogController = new DogController(repository,customerRepository);
		CustomerDTO customerDTO = new CustomerDTO(null,null,null,null,0);
		DogDTO dogDTO = new DogDTO("Jean","Boxer",0,25.0f,customerDTO);
		
		//Act
		dogController.add(dogDTO);
		
		//Assert
		assertTrue(repository.hasAddBeenCalled);
		assertEquals("Jean", repository.elementAdded.getName());
		assertEquals("Boxer", repository.elementAdded.getBreed());
	}

}
