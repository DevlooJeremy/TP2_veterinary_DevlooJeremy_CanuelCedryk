package mock;

import dogs.controller.IDogController;
import dto.DogDTO;

public class DogControllerSpy implements IDogController{

	public boolean hasGoToCreateBeenCalled = false;
	public boolean hasAddBeenCalled = false;
	
	@Override
	public void goToCreate() {
		this.hasGoToCreateBeenCalled = true;
	}

	@Override
	public void add(DogDTO dogDTO) {
		this.hasAddBeenCalled = true;
	}

	@Override
	public boolean verifyIfOwnerExist(String lastName) {
		// TODO Auto-generated method stub
		return false;
	}

}
