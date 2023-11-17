package mock;

import dogs.controller.IDogListController;

public class ListControllerSpy implements IDogListController{

	
	public boolean hasGoToCreateBeenCalled = false;
	@Override
	public void goToCreate() {
		this.hasGoToCreateBeenCalled = true;
		
	}

}
