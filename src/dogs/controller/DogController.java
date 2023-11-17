package dogs.controller;

import dog.converter.DogConverter;
import dogRepository.IDogRepository;
import dogs.model.Dog;
import dogs.view.DogCreateView;
import dogs.view.IView;
import dto.DogDTO;

public class DogController implements IDogController{


	private IDogRepository repository;
	
	public DogController(IDogRepository repository) {
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
