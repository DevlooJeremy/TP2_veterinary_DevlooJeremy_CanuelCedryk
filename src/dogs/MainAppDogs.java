package dogs;

import dataSeeder.DataSeeder;
import dogRepository.DogMemoryRepository;
import dogRepository.IDogRepository;
import dogs.controller.DogController;
import dogs.controller.DogListController;
import dogs.controller.IDogController;
import dogs.controller.IDogListController;
import dogs.controller.IWelcomeController;
import dogs.controller.WelcomeController;

public class MainAppDogs {

	private IDogRepository repository;
	public static void main(String[] args) {
		new MainAppDogs();
	}

	public MainAppDogs() {
		IDogRepository repository = new DogMemoryRepository();
		this.repository = repository;
		DataSeeder seeder = new DataSeeder(this.repository);
		this.createControllers();
	}
	
	private void createControllers() {
		IDogController createDog = new DogController(repository);
		IDogListController listController = new DogListController(this.repository);
		IWelcomeController appController = new WelcomeController(createDog,listController);
		appController.startApplication();
	}

}
