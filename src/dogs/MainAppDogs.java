package dogs;

import dataSeeder.CustomerSeeder;
import dataSeeder.DogSeeder;
import dogRepository.CustomerMemoryRepository;
import dogRepository.DogMemoryRepository;
import dogRepository.ICustomerRepository;
import dogRepository.IDogRepository;
import dogs.controller.CustomerController;
import dogs.controller.DogController;
import dogs.controller.DogListController;
import dogs.controller.ICustomerController;
import dogs.controller.IDogController;
import dogs.controller.IDogListController;
import dogs.controller.IWelcomeController;
import dogs.controller.WelcomeController;

public class MainAppDogs {

	private IDogRepository dogRepository;
	private ICustomerRepository customerRepository;
	public static void main(String[] args) {
		new MainAppDogs();
	}

	public MainAppDogs() {
		IDogRepository repository = new DogMemoryRepository();
		ICustomerRepository customerRepository = new CustomerMemoryRepository();
		this.dogRepository = repository;
		this.customerRepository = customerRepository;
		DogSeeder seeder = new DogSeeder(this.dogRepository);
		CustomerSeeder customerSeeder = new CustomerSeeder(this.customerRepository);
		this.createControllers();
	}
	
	private void createControllers() {
		IDogController createDog = new DogController(dogRepository);
		IDogListController listController = new DogListController(this.dogRepository);
		ICustomerController customerController = new CustomerController(this.customerRepository);
		IWelcomeController appController = new WelcomeController(createDog,listController,customerController);
		appController.startApplication();
	}

}
