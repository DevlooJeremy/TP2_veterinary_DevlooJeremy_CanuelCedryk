package dogs.controller;

import dogRepository.IEntityRepository;
import dogs.model.Dog;
import dogs.view.DogListView;

public class DogListController implements IDogListController{

	
	private IEntityRepository<Dog> repository;
	
	public DogListController(IEntityRepository<Dog> repository) {
		this.repository = repository;
	}
	@Override
	public void goToCreate() {
		DogListView listView = new DogListView(this,this.repository);
		listView.display();
	}

}
