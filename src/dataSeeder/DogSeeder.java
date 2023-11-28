package dataSeeder;

import dogRepository.IEntityRepository;
import dogs.model.Dog;

public class DogSeeder {

	public DogSeeder(IEntityRepository<Dog> repository) {		
		repository.add(new Dog("Jean","Husky"));
		repository.add(new Dog("Michel","Golden"));
		repository.add(new Dog("Robert","Grand Danois"));
		repository.add(new Dog("Roger","Shiba"));
		repository.add(new Dog("Viateur","Boxer"));
	}
}
