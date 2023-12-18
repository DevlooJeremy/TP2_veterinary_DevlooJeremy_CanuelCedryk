package dogs.controller;

import dog.converter.DogConverter;
import dogRepository.IEntityRepository;
import dogs.model.Customer;
import dogs.model.Dog;
import dogs.view.DogCreateView;
import dogs.view.IView;
import dto.DogDTO;

public class DogController implements IDogController{


	private IEntityRepository<Dog> repository;
	private IEntityRepository<Customer> customerRepository;
	
	public DogController(IEntityRepository<Dog> repository,IEntityRepository<Customer> customerRepository) {
		this.repository = repository;
		this.customerRepository = customerRepository;
	}
	
	@Override
	public void goToCreate() {
		IView dogCreateView = new DogCreateView(this);
		dogCreateView.display();
	}
	
	@Override
	public void add(DogDTO dogDTO) {
		DogConverter converter = new DogConverter();
		Dog dog = converter.dtoToDog(dogDTO);
		this.repository.add(dog);
	}
	

}
