package dogs.controller;

import dogRepository.IDogRepository;
import dogs.view.DogListView;

public class DogListController implements IDogListController{

	
	private IDogRepository repository;
	
	public DogListController(IDogRepository repository) {
		this.repository = repository;
	}
	@Override
	public void goToCreate() {
		DogListView listView = new DogListView(this,this.repository);
		listView.display();
	}

}
