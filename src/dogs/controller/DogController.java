package dogs.controller;

import java.util.ArrayList;
import java.util.Collection;

import dog.converter.DogConverter;
import dogRepository.IEntityRepository;
import dogs.model.Customer;
import dogs.model.Dog;
import dogs.observer.IObserver;
import dogs.searcher.CustomerSearcherFabric;
import dogs.view.DogCreateView;
import dogs.view.IView;
import dto.DogDTO;

public class DogController implements IDogController{

	private IObserver observer;
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
		CustomerSearcherFabric factory = new CustomerSearcherFabric();
		ArrayList<Customer> customers = customerRepository.search(factory.getStrategyToResearchCustomerByName(dog.getOwner().getLastName()));
		dog.setOwner(customers.get(0));
		this.repository.add(dog);
	}

	@Override
	public boolean verifyIfOwnerExist(String lastName) {
		ArrayList<Customer> result = this.customerRepository.search(new CustomerSearcherFabric().getStrategyToResearchCustomerByName(lastName));
		if(result.isEmpty()){
			return false;
		}
		return true;
	}

	@Override
	public void addObserver(IObserver observer) {
		this.observer = observer;
	}

	@Override
	public void removeObserver(IObserver observer) {
		this.observer = null;
	}

	@Override
	public void notifyObserver() {
		this.observer.update();
	}
	

}
