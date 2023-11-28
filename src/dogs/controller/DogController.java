package dogs.controller;

import dog.converter.DogConverter;
import dogRepository.IEntityRepository;
import dogs.model.Dog;
import dogs.view.DogCreateView;
import dogs.view.IView;
import dto.DogDTO;

public class DogController implements IDogController{


	private IEntityRepository<Dog> repository;
	
	public DogController(IEntityRepository<Dog> repository) {
		this.repository = repository;
	}
	
	@Override
	public void goToCreate() {
		IView dogCreateView = new DogCreateView(this);
		dogCreateView.display();
	}
	
	@Override
	public void add(DogDTO dogDTO) {
		DogConverter converter = new DogConverter();
		this.repository.add(converter.dtoToDog(dogDTO));
	}
	

}
