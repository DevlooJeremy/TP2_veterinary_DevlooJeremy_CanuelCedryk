package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dogs.controller.DogController;
import dogs.controller.WelcomeController;
import mock.DogControllerSpy;
import mock.ListControllerSpy;
import mock.CustomerControllerSpy;

class WelcomeControllerTest {

	@Test
	void WelcomeControllerCanCallDogController() {
		//Arrange
		DogControllerSpy dogController = new DogControllerSpy();
		ListControllerSpy listController = new ListControllerSpy();
		CustomerControllerSpy customerController = new CustomerControllerSpy();
		WelcomeController welcomeController = new WelcomeController(dogController,listController,customerController);
		
		//Act
		welcomeController.wantToCreateDog();
		
		//Assert
		assertTrue(dogController.hasGoToCreateBeenCalled);
	}
	
	@Test
	void WelcomeControllerCanCallListController() {
		//Arrange
		DogControllerSpy dogController = new DogControllerSpy();
		ListControllerSpy listController = new ListControllerSpy();
		CustomerControllerSpy customerController = new CustomerControllerSpy();
		WelcomeController welcomeController = new WelcomeController(dogController,listController,customerController);
		
		//Act
		welcomeController.wantToListDog();
		
		//Assert
		assertTrue(listController.hasGoToCreateBeenCalled);
	}

}
