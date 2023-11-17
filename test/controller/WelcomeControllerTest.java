package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dogs.controller.DogController;
import dogs.controller.WelcomeController;
import mock.DogControllerSpy;
import mock.ListControllerSpy;

class WelcomeControllerTest {

	@Test
	void WelcomeControllerCanCallDogController() {
		//Arrange
		DogControllerSpy dogController = new DogControllerSpy();
		ListControllerSpy listController = new ListControllerSpy();
		WelcomeController welcomeController = new WelcomeController(dogController,listController);
		
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
		WelcomeController welcomeController = new WelcomeController(dogController,listController);
		
		//Act
		welcomeController.wantToListDog();
		
		//Assert
		assertTrue(listController.hasGoToCreateBeenCalled);
	}

}
