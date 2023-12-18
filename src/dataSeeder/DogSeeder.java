package dataSeeder;

import dogRepository.IEntityRepository;
import dogs.model.Customer;
import dogs.model.Dog;

public class DogSeeder {

	public DogSeeder(IEntityRepository<Dog> dogRepository,IEntityRepository<Customer> customerRepository) {	
		Customer customer = customerRepository.searchById(0);
		dogRepository.add(new Dog("Jean","Husky",15.0f,customer));
		dogRepository.add(new Dog("Michel","Golden",25.0f,customer));
		dogRepository.add(new Dog("Robert","Grand Danois",30.0f,customer));
		dogRepository.add(new Dog("Roger","Shiba",10.0f,customer));
		dogRepository.add(new Dog("Viateur","Boxer",17.3f,customer));
	}
}
