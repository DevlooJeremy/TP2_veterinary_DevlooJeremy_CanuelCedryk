package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dogs.controller.DogController;
import dogs.model.Dog;
import dto.DogDTO;
import mock.RepositorySpy;

class DogControllerTest {

	@Test
	void dogControllerCanAddDogToRepository() {
		//Arrange
		RepositorySpy<Dog> repository = new RepositorySpy<Dog>();
		DogController dogController = new DogController(repository);
		DogDTO dogDTO = new DogDTO("Jean","Boxer",0);
		
		//Act
		dogController.add(dogDTO);
		
		//Assert
		assertTrue(repository.hasAddBeenCalled);
		assertEquals("Jean", repository.elementAdded.getName());
		assertEquals("Boxer", repository.elementAdded.getBreed());
	}

}
