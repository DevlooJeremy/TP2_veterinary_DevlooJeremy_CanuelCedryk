package dogs.observer;

import dogs.controller.IDogListController;

public class DogListObserver implements IObserver{

	private IDogListController controller;
	
	public DogListObserver(IDogListController controller) {
		this.controller = controller;
	}
	
	@Override
	public void update() {
		this.controller.update();
	}

}
