package dogs.controller;

import dogRepository.IEntityRepository;
import dogs.model.Dog;
import dogs.view.DogListView;

public class DogListController implements IDogListController{

	private DogListView view;
	private IEntityRepository<Dog> repository;
	
	public DogListController(IEntityRepository<Dog> repository) {
		this.repository = repository;
	}
	@Override
	public void goToCreate() {
		DogListView listView = new DogListView(this,this.repository);
		this.view = listView;
		listView.display();
	}
	@Override
	public void update() {
		if (this.view != null) this.view.updateList();
	}

}
