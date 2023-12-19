package mock;

import dogs.controller.IDogListController;

public class ListControllerSpy implements IDogListController{

	
	public boolean hasGoToCreateBeenCalled = false;
	public boolean hasUpdateBeenCalled = false;
	
	@Override
	public void goToCreate() {
		this.hasGoToCreateBeenCalled = true;
		
	}
	@Override
	public void update() {
		this.hasUpdateBeenCalled = true;
		
	}

}
