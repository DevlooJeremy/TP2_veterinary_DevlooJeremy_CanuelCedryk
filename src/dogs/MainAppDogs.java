package dogs;

import dataSeeder.CustomerSeeder;
import dataSeeder.DogSeeder;
import dogRepository.EntityMemoryRepository;
import dogRepository.IEntityRepository;
import dogs.controller.CustomerController;
import dogs.controller.DogController;
import dogs.controller.DogListController;
import dogs.controller.ICustomerController;
import dogs.controller.IDogController;
import dogs.controller.IDogListController;
import dogs.controller.IWelcomeController;
import dogs.controller.WelcomeController;
import dogs.model.Customer;
import dogs.model.Dog;
import dogs.observer.DogListObserver;
import dogs.observer.IObserver;

public class MainAppDogs {

	private IEntityRepository<Dog> dogRepository;
	private IEntityRepository<Customer> customerRepository;
	public static void main(String[] args) {
		new MainAppDogs();
	}

	public MainAppDogs() {
		IEntityRepository<Dog> repository = new EntityMemoryRepository<Dog>();
		IEntityRepository<Customer> customerRepository = new EntityMemoryRepository<Customer>();
		this.dogRepository = repository;
		this.customerRepository = customerRepository;
		CustomerSeeder customerSeeder = new CustomerSeeder(this.customerRepository);
		DogSeeder seeder = new DogSeeder(this.dogRepository,this.customerRepository);
		this.createControllers();
	}
	
	private void createControllers() {
		IDogController createDog = new DogController(dogRepository,customerRepository);
		IDogListController listController = new DogListController(this.dogRepository);
		ICustomerController customerController = new CustomerController(this.customerRepository);
		IWelcomeController appController = new WelcomeController(createDog,listController,customerController);
		DogListObserver observer = new DogListObserver(listController);
		createDog.addObserver(observer);
		appController.startApplication();
	}

}
